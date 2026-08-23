class Solution {
    public int maxSubArray(int[] nums) {
        int curSum = 0;
        int res = nums[0];
        for(int num : nums){
            if (curSum < 0){
                curSum = 0;
            }
            curSum += num;
            res = Math.max(curSum, res);
        }
        return res;
    }
}
