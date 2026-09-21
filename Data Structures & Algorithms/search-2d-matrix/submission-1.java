class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        int topRow = 0;
        int bottomRow = ROWS - 1;
        while (topRow <= bottomRow){
            int row = (topRow + bottomRow)/2;
            if (matrix[row][0] > target){
                bottomRow = row - 1;
            }
            else if(matrix[row][COLS-1] < target){
                topRow = row + 1;
            }
            else{
                break;
            }
        }

        if (topRow > bottomRow){
            return false;
        }
        int row = (topRow + bottomRow)/2;
        int first = 0;
        int last = COLS-1;
        while(first <= last){
            int term = (first + last)/2;
            if(matrix[row][term]> target){
                last = term-1;
            }
            else if(matrix[row][term]<target){
                first = term+1;
            }
            else{
                return true;
            }
        }

        return false;
    }
}
