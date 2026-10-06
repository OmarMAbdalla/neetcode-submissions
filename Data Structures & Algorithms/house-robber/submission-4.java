class Solution {
    public int rob(int[] nums) {
        int prev1 = 0;
        int prev2 = 0;
        if(nums.length >= 2){
            prev1 = Math.max(nums[1],nums[0]);
            prev2 = nums[0];
        }else if(nums.length == 1){
            return nums[0];
        }else{
            return -1;
        }

        for(int i = 2; i < nums.length; i++){
            int currMax = Math.max(prev2+nums[i],prev1);
            prev2 = prev1;
            prev1 = currMax;
        }
        return Math.max(prev1,prev2);
    }
}
