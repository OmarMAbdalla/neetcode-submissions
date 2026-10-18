class Solution {
    private int[][] memo;
    public int lengthOfLIS(int[] nums) {
        memo = new int[nums.length][nums.length + 1];
        for (int[] row : memo) Arrays.fill(row, -1);
        return dfs(nums, 0, -1);
    }

    private int dfs(int[] nums, int i, int j){
        if(i==nums.length){
            return 0;
        }
        if (memo[i][j + 1] != -1) {
            return memo[i][j + 1];
        }

        int LIS = dfs(nums, i+1, j); // do not include

        if(j == -1 || nums[j]<nums[i]){
            LIS = Math.max(LIS, 1+ dfs(nums,i+1,i));
        }

        memo[i][j + 1] = LIS;
        return LIS;
    }
}
