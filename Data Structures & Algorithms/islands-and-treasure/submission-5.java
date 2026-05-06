class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        boolean[][] visited = new boolean[ROWS][COLS];
        Queue<int[]> queue = new LinkedList<>();
        for(int r = 0;r<ROWS;r++){
            for(int c = 0;c<COLS;c++){
                if(grid[r][c]==0){
                    visited[r][c] = true;
                    queue.add(new int[]{r,c});
                }
            }
        }
        int distance = 0;
        int[][] dirs = { { -1, 0 }, { 0, -1 },
                         { 1, 0 }, { 0, 1 } };
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i = 0;i<n;i++){
                int[] pos = queue.poll();
                int r = pos[0],c=pos[1];
                grid[r][c] = Math.min(distance,grid[r][c]);
                for(int[] dir:dirs){
                    int nR = r+dir[0],nC = c+dir[1];
                    if(nR<0 || nR>=ROWS || nC<0 || nC>=COLS || visited[nR][nC] || grid[nR][nC]==-1){
                        continue;
                    }
                    queue.add(new int[]{nR,nC});
                    visited[nR][nC] = true;
                }
            }
            distance++;
        }
    }
}
