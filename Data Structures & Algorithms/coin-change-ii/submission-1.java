class Solution {
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        int [][] memo = new int[coins.length+1][amount+1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dfs(coins, 0, amount, memo);
    }

    private int dfs(int[] coins, int i, int amount, int[][] memo){
        if(amount == 0){
            return 1;
        }
        if(i >= coins.length){
            return 0;
        }
        if(memo[i][amount] != -1 ) return memo[i][amount];

        int res = 0;

        if(amount >= coins[i]){
            res = dfs(coins, i+1, amount, memo);
            res += dfs(coins, i, amount-coins[i], memo);
        }
        memo[i][amount] = res;

        return res;
    }
}
