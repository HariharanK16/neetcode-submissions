class Solution {
    int ROWS,COLS,fresh,time;
    Queue<int[]> q;

    public int orangesRotting(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        fresh = 0; time = 0;

        q = new LinkedList<>();

        for(int i = 0;i<ROWS;i++){
            for(int j = 0; j<COLS;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                } else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while(fresh>0 && !q.isEmpty()){
            int n = q.size();
            for(int i = 0;i<n;i++){
                int[] pos = q.poll();
                int r = pos[0], c= pos[1];
                for (int[] dir : directions) {
                    int row = r + dir[0];
                    int col = c + dir[1];
                    if (row >= 0 && row < grid.length &&
                        col >= 0 && col < grid[0].length &&
                        grid[row][col] == 1) {
                        grid[row][col] = 2;
                        q.offer(new int[]{row, col});
                        fresh--;
                    }
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}
