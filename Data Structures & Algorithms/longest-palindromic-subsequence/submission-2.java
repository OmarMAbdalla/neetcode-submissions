class Solution {
    private int[][] dp;
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        dp = new int[n][n];

        for (int[] row : dp) {
            Arrays.fill(row,-1);
        }

        for(int i = 0; i < n; i++){
            dfs(i, i, s);
            dfs(i, i+1,s);
        }
        int maxLength = 0;

        for(int[] row: dp){
            for(int val : row){
                maxLength = Math.max(maxLength, val);
            }
        }
        return maxLength;
    }
    private int dfs(int i, int j, String s){
        if(i < 0 || j == s.length()){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        if(s.charAt(i)==s.charAt(j)){
            int length = (i==j)? 1 : 2;
            dp[i][j] = length + dfs(i-1, j+1,s);
        }else{
            dp[i][j] = Math.max(dfs(i-1,j,s),dfs(i,j+1,s));
        }
        return dp[i][j];
    }
}