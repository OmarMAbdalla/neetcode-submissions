class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zeroCount = 0;
        int totalProduct = 1;
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i]== 0)
            {
                zeroCount++;
            } else{
                totalProduct *= nums[i];
            }
        }

        if (zeroCount > 1){
            return new int[nums.length];
        }
        int[] result = new int [nums.length];
        for(int i =0; i < nums.length; i++){
            if (zeroCount > 0){
                result[i] = (nums[i]==0)? totalProduct : 0;
            } else {
                result[i] = totalProduct / nums[i];
            }
        }
    return result;

    }
}  
