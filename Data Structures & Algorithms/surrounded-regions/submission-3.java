class Solution {
    public void solve(char[][] board) {
        Queue<int[]> queue = new LinkedList<>();

        int ROWS = board.length;
        int COLS = board[0].length;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        for(int r = 0;r<ROWS;r++){
            if(board[r][0]=='O'){
                queue.add(new int[]{r,0});
            }
            if(board[r][COLS-1]=='O'){
                queue.add(new int[]{r,COLS-1});
            }
        }
        for(int c = 0;c<COLS;c++){
            if(board[0][c]=='O'){
                queue.add(new int[]{0,c});
            }
            if(board[ROWS-1][c]=='O'){
                queue.add(new int[]{ROWS-1,c});
            }
        }

        while(!queue.isEmpty()){
            int[] pos = queue.poll();

            int r = pos[0];
            int c = pos[1];
            board[r][c] = 'T';
            for(int[] dir:dirs){
                int nr = r+dir[0];
                int nc = c+dir[1];
                if(nr<0 || nc<0 || nr==ROWS || nc==COLS || board[nr][nc]!='O' || board[nr][nc] == 'T'){
                    continue;
                }
                queue.add(new int[]{nr,nc});
            }
        }

         for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                } else if (board[r][c] == 'T') {
                    board[r][c] = 'O';
                }
            }
        }
    }
}
