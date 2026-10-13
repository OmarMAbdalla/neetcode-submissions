class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i=0; i < 9; i++){
            HashSet<Integer> curRow = new HashSet<>();

            for(int j = 0; j < 9; j++){
                if(board[i][j]=='.'){
                    continue;
                }
                if(curRow.contains(board[i][j]-'0')){
                    return false;
                }
                curRow.add(board[i][j]-'0');

            }
            HashSet<Integer> curCol = new HashSet<>();

            for(int j = 0; j < 9; j++){
                if(board[j][i]=='.'){
                    continue;
                }
                if(curCol.contains(board[j][i]-'0')){
                    return false;
                }
                curCol.add(board[j][i]-'0');

            }
        }
    
        for (int square = 0; square < 9; square++) {
            Set<Character> seen = new HashSet<>();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int row = (square / 3) * 3 + i;
                    int col = (square % 3) * 3 + j;
                    if (board[row][col] == '.') continue;
                    if (seen.contains(board[row][col])) return false;
                    seen.add(board[row][col]);
                }
            }
        }
        return true;
    }
}
