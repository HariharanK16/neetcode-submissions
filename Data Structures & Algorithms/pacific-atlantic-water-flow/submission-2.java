class Solution {
    
    int ROWS,COLS;
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] por,aor;
        Queue<int[]> pq,aq;
        ROWS = heights.length;
        COLS = heights[0].length;
        pq = new LinkedList<>();
        aq = new LinkedList<>();
        por = new boolean[ROWS][COLS];
        aor = new boolean[ROWS][COLS];

        for(int r = 0;r<ROWS;r++ ){
            pq.add(new int[]{r,0});
            aq.add(new int[]{r,COLS-1});
            por[r][0] = true;
            aor[r][COLS-1] = true;
        }
        for(int c = 0;c<COLS;c++ ){
            pq.add(new int[]{0,c});
            aq.add(new int[]{ROWS-1,c});
            por[0][c] = true;
            aor[ROWS-1][c] = true;
        }

        bfs(por,pq,heights);
        bfs(aor,aq,heights);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0;i<ROWS;i++){
            
            for(int j = 0;j<COLS;j++){
                int pos[] = new int[]{i,j};
                if(por[i][j] && aor[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }

        }
        return res;

    }

    private void bfs(boolean[][] visit, Queue<int[]> q, int[][] heights){
        while(!q.isEmpty()){
            int n = q.size();

            int pos[] = q.poll();
            int r = pos[0],c=pos[1];
            visit[r][c] = true;
            for(int dir[]:directions){
                int row = r+ dir[0];
                int col = c+ dir[1];
                if(row<0 || col <0 || row == ROWS || col == COLS || visit[row][col] || heights[row][col]<heights[r][c]){
                    continue;
                }
                q.add(new int[]{row,col});
                
            }
            
        }
    }
}
