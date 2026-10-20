class Solution {
    private boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(backtracking(board, i, j, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }


    private boolean backtracking(char[][] board, int i, int j, String word, int index){
        if(index == word.length()){
            return true;
        }

        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(index) ||visited[i][j]){
            return false;
        }
        visited[i][j] = true;
        boolean res= backtracking(board, i+1, j, word, index+1) ||
        backtracking(board, i-1, j, word, index+1) ||
        backtracking(board, i, j+1, word, index+1) ||
        backtracking(board, i, j-1, word, index+1);

        visited[i][j] = false;
        return res;
    }
}
