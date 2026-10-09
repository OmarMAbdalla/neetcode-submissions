class Solution {
    int maxCount = 0;
    public int maxAreaOfIsland(int[][] grid) {
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c<grid[0].length; c++){
                if(grid[r][c]==1){
                    maxCount = Math.max(maxCount, dfs(grid, r, c, 0));
                }
            }
        }
        return maxCount;

    }

    private int dfs(int[][] grid, int r, int c, int count){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0)      
        {
            return 0;
        }
        grid[r][c] = 0;
        maxCount = Math.max(count+1, maxCount);

        return 1 + dfs(grid, r+1, c, count+1) + dfs(grid, r-1, c, count+1) + dfs(grid, r, c+1, count+1) + dfs(grid, r, c-1, count+1) ;



    }
}
