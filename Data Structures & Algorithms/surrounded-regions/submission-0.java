class Solution {
    int ROWS,COLS;
    public void solve(char[][] board) {
        ROWS = board.length;
        COLS = board[0].length;

        for (int r = 0; r < ROWS; r++) {
            if (board[r][0] == 'O') {
                dfs(board, r, 0);
            }
            if (board[r][COLS - 1] == 'O') {
                dfs(board, r, COLS - 1);
            }
        }

        for (int c = 0; c < COLS; c++) {
            if (board[0][c] == 'O') {
                dfs(board, 0, c);
            }
            if (board[ROWS - 1][c] == 'O') {
                dfs(board, ROWS - 1, c);
            }
        }

        for(int i = 0;i<ROWS;i++){
            for(int j = 0;j<COLS;j++){
                if(board[i][j] == 'O'){
                    board[i][j]='X';
                } else if(board[i][j] == 'T'){
                    board[i][j]='O';
                }
            }
        }
    }
    private void dfs(char[][] board, int r,int c){
        if(r<0 || c<0 || r==ROWS || c == COLS || board[r][c]!='O'){
            return;
        }
        board[r][c] = 'T';

        dfs(board,r+1,c);
        dfs(board,r-1,c);
        dfs(board,r,c+1);
        dfs(board,r,c-1);
    }
}
