class Solution {
    boolean[][] visited;
    Queue<int[]> queue;
    int ROWS,COLS;
    public void islandsAndTreasure(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        visited = new boolean[ROWS][COLS];
        queue = new LinkedList<>();

        for(int i = 0;i<ROWS;i++){
            for(int j = 0;j<COLS;j++){
                if(grid[i][j]==0){
                    queue.add(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }
        int dist = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i<size;i++){
                int[] pos = queue.poll();
                int r = pos[0], c = pos[1];
                grid[r][c] = Math.min(dist,grid[r][c]);
                addToQueue(r+1,c,grid);
                addToQueue(r-1,c,grid);
                addToQueue(r,c+1,grid);
                addToQueue(r,c-1,grid);
            }
            dist+=1;
        }
    }

    private void addToQueue(int r,int c, int[][] grid){
        if(r<0 || c< 0 || r>=ROWS || c >= COLS || visited[r][c] || grid[r][c] == -1){
            return;
        }
        queue.add(new int[]{r,c});
        visited[r][c] = true;
    }
}
