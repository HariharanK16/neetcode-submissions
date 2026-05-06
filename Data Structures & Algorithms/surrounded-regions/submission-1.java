class Solution {
    public void solve(char[][] board) {
        int R = board.length;
        int C = board[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for(int r = 0;r<R;r++){
            if(board[r][0]=='O'){
                queue.add(new int[]{r,0});
            }
            if(board[r][C-1]=='O'){
                queue.add(new int[]{r,C-1});
            }
        }
        for(int c = 0;c<C;c++){
            if(board[0][c]=='O'){
                queue.add(new int[]{0,c});
            }
            if(board[R-1][c]=='O'){
                queue.add(new int[]{R-1,c});
            }
        }

        int dir[][] = {{1,0} , {0,1}, {-1,0}, {0,-1}};
        while(!queue.isEmpty()){
            int pos[] = queue.poll();
            int r = pos[0];
            int c = pos[1];
            board[r][c] = 'T';
            for(int[] d:dir){
                int nr = d[0] + r;
                int nc = d[1] + c;
                if(nr<0 || nc<0 || nr>=R || nc>=C || board[nr][nc]!='O' || board[nr][nc]=='T'){
                    continue;
                }
                queue.offer(new int[]{nr,nc});

            }
        }
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                } else if (board[r][c] == 'T') {
                    board[r][c] = 'O';
                }
            }
        }
    }
}
