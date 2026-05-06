class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int R = grid.length;
        int C = grid[0].length;

        Queue<int[]> queue = new LinkedList();
        for(int r = 0;r<R;r++){
            for(int c = 0;c<C;c++){
                if(grid[r][c]==0){
                    queue.add(new int[]{r,c});
                }
            }
        }

        if(queue.isEmpty()) return;
        
        int distance = 0;
        int[][] dirs = { { -1, 0 }, { 0, -1 },
                         { 1, 0 }, { 0, 1 } };
                         
        while(!queue.isEmpty()){
            int n = queue.size();
            
            for(int i = 0;i<n;i++){
                int[] pos = queue.poll();
                int r = pos[0];
                int c = pos[1];

                for(int[] dir:dirs){
                    int nr = r+dir[0];
                    int nc = c+dir[1];

                    if(nr<0 || nc<0 || nr>=grid.length || nc>=grid[0].length || grid[nr][nc]!=Integer.MAX_VALUE) continue;

                    queue.add(new int[]{nr,nc});
                    grid[nr][nc] = distance+1;
                }
            }
            distance++;
        }
    }
}
