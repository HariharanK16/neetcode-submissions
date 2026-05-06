class Solution {
    int ROWS, COLS;
    int[][] dirs = { { -1, 0 }, { 0, -1 },
                         { 1, 0 }, { 0, 1 } };
    boolean[][] aov,pov;
    Queue<int[]> pq,aq;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        pq = new LinkedList<>();
        aq = new LinkedList<>();

        ROWS = heights.length;
        COLS = heights[0].length;

        aov = new boolean[ROWS][COLS];
        pov = new boolean[ROWS][COLS];

        for(int r = 0;r<ROWS;r++){
            pq.add(new int[]{r,0});
            aq.add(new int[]{r,COLS-1});
        }

        for(int c = 0;c<COLS;c++){
            pq.add(new int[]{0,c});
            aq.add(new int[]{ROWS-1,c});
        }

        bfs(heights,aq,aov);
        bfs(heights,pq,pov);

        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0;i<ROWS;i++){
            
            for(int j = 0;j<COLS;j++){
                int pos[] = new int[]{i,j};
                if(pov[i][j] && aov[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }

        }
        return res;
    }

    private void bfs(int[][] heights, Queue<int[]> q, boolean[][] visit){
        while(!q.isEmpty()){
            int pos[] = q.poll();
            int r = pos[0],c=pos[1];
            visit[r][c] = true;
            for(int dir[]:dirs){
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
