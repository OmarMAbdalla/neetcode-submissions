class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0]==1) return 0; 
        
        int[] row = new int[obstacleGrid[0].length];

        row[0] = 1;

        for(int i = 0; i < obstacleGrid.length; i++){
            for(int j=0; j < obstacleGrid[0].length; j++){
                if(obstacleGrid[i][j]==1){
                    row[j] = 0;
                }else if (j>0){
                    row[j]=row[j]+row[j-1];
                }
            }
        }
        return row[obstacleGrid[0].length-1];
    }
}