class Solution {
    int ROWS,COLS,max;
    public int maxAreaOfIsland(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        max = 0;

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
        if(r<0 || c<0 || r>=ROWS || c>=COLS || grid[r][c]==0){
            return 0;
        }
        grid[r][c] = 0;

        int count  = 1 + dfs(grid,r+1,c) + 
        dfs(grid,r-1,c) +
        dfs(grid,r,c+1) +
        dfs(grid,r,c-1);


        return count;
    }
}
