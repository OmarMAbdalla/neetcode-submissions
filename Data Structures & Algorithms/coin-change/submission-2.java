class Solution {
    int[] dp;
    public int coinChange(int[] coins, int amount) {
        dp = new int[amount+1];
        return dfs(coins, amount) >= Integer.MAX_VALUE-1000? -1:dfs(coins, amount);
    }

    private int dfs(int[] coins, int amount){
        if(amount == 0){
            return 0;
        }
        if(dp[amount] !=0){
            return dp[amount];
        }

        int res = Integer.MAX_VALUE-1000;

        for(int coin : coins){
            if(amount-coin >= 0){
                res = Math.min(res, 1+dfs(coins, amount-coin));
            }
        }
        dp[amount]=res;
        return res;
    }
}
