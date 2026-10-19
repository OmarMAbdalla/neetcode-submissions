class Solution {
    Integer[][] memo;
    Boolean[][] palMemo;

    public int countSubstrings(String s) {
        memo = new Integer[s.length()][s.length()];
        palMemo = new Boolean[s.length()][s.length()];

        return dfs(s,0,s.length()-1);
    }

    private int dfs(String s, int i , int j){
        if (i > j) return 0;
        if(j==i) return 1;
        if (memo[i][j] != null) return memo[i][j];


        if(isPal(s,i,j)){
            int res = 1 + dfs(s, i+1, j) + dfs(s, i, j-1)- dfs(s, i+1, j-1);
            memo[i][j] = res;
            return res;
        }
        int res = dfs(s, i+1, j) + dfs(s, i, j-1)- dfs(s, i+1, j-1);
        memo[i][j] = res;
        return res;

    }

    private boolean isPal(String s, int i, int j) {
    if (i >= j) return true;
    if (palMemo[i][j] != null) return palMemo[i][j];
    return palMemo[i][j] = s.charAt(i) == s.charAt(j) && isPal(s, i + 1, j - 1);
    }

}
