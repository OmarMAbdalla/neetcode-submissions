class Solution {

    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length ==1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int[] memo = new int[nums.length-1];
        memo[0] = nums[0];
        memo[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < nums.length-1; i++){
            memo[i] = Math.max(memo[i-2]+nums[i],memo[i-1]);
        }
        
        int[] memo2 = new int[nums.length-1];
        memo2[0] = nums[1];
        memo2[1] = Math.max(nums[2], nums[1]);

        for(int i = 3; i < nums.length; i++){
            memo2[i-1] = Math.max(memo2[i-3]+nums[i],memo2[i-2]);
        }

        return Math.max(memo[nums.length-2], memo2[nums.length-2]);
    }
}

