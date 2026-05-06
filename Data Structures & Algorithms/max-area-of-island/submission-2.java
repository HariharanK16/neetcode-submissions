class Solution {
    int ROWS,COLS,max;
    boolean[][] visited;
    public int maxAreaOfIsland(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        max = 0;
        visited = new boolean[ROWS][COLS];

        for(int i = 0 ; i < ROWS; i++){
            for(int j = 0 ; j < COLS; j++){
                if(grid[i][j]==1){
                    max = Math.max(dfs(grid,i,j),max);
                }
            }
        }
        return max;
    }

    public int dfs(int[][] grid, int r, int c){
        if(r<0 || c<0 || r>=ROWS || c>=COLS || visited[r][c] || grid[r][c]==0){
            return 0;
        }
        visited[r][c]=true;

        int count  = 1 + dfs(grid,r+1,c) + 
        dfs(grid,r-1,c) +
        dfs(grid,r,c+1) +
        dfs(grid,r,c-1);
        grid[r][c] = 0;
        visited[r][c] = false;
        return count;
    }
}
