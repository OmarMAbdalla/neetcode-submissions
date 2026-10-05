class Solution {
    public boolean exist(char[][] board, String word) {
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[0].length; c++){
                if(board[r][c] == word.charAt(0)){
                    if(backtrack(word, board,r,c,0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean backtrack(String word, char[][] board,int r,int c,int i ){
        if(word.length()==i){
            return true;
        }
        if(r < 0 || c < 0|| r >= board.length || c >= board[0].length || board[r][c] != word.charAt(i)){
            return false;
        }

        board[r][c] ='*';
        boolean res = backtrack(word, board, r+1, c, i+1) ||
                    backtrack(word, board, r-1, c, i+1) ||
                    backtrack(word, board, r, c+1, i+1) ||
                    backtrack(word, board, r, c-1, i+1);
        board[r][c] = word.charAt(i);

        return res;

    }
}
