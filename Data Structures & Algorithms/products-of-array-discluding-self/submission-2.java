class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int product = 1; 
        boolean oneZero = false;
        int zeroIndex = -1;
        boolean twoZero = false;

        for(int i = 0; i < nums.length; i++){
            if(nums[i]==0){
                if(oneZero){
                    twoZero = true;
                    break;
                }else{
                    oneZero = true;
                    zeroIndex = i;
                }
            }else{
                product *= nums[i];
            }
            
        }

        if(twoZero){
            return res;
        }

        if(oneZero){
            res[zeroIndex] = product;
            return res;
        }

        for(int i = 0; i < nums.length; i++){
            res[i] = product/nums[i];
        }
        return res;
    }
}  
