class Solution {
    public boolean exist(char[][] board, String word) {
        int r = board.length;
        int c = board[0].length;

        for(int i = 0; i< r;i++){
            for(int j = 0;j<c;j++){
                if(board[i][j]==word.charAt(0)){
                    if(dfs(board,word,i,j,0)){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int ind){
        if(ind == word.length()){
            return true;
        }
        if(r<0 || c<0 || r>=board.length || c>=board[0].length || word.charAt(ind)!=board[r][c]||board[r][c]=='.'){
            return false;
        }
        board[r][c] = '.';
        boolean res = dfs(board,word,r+1,c,ind+1)||
        dfs(board,word,r-1,c,ind+1)||
        dfs(board,word,r,c+1,ind+1)||
        dfs(board,word,r,c-1,ind+1);
        board[r][c] = word.charAt(ind);

        return res;

    }
}
