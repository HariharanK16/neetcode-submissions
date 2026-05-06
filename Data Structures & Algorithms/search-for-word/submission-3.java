class Solution {
    int r,c;
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {


        r = board.length;
        c = board[0].length;
        visited = new boolean[r][c];

        for(int i = 0; i< r;i++){
            for(int j = 0;j<c;j++){
                if(board[i][j]==word.charAt(0)){
                    if(dfs(board,word,i,j,0)){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word,int i, int j, int ind){
        if(ind == word.length()){
            return true;
        }
        if(i < 0 || j< 0 || i>=r || j>=c || board[i][j] != word.charAt(ind)|| visited[i][j]){
            return false;
        }
        visited[i][j] = true;
        boolean res = 
        dfs(board,word,i+1,j,ind+1) ||
        dfs(board,word,i-1,j,ind+1) ||
        dfs(board,word,i,j+1,ind+1) ||
        dfs(board,word,i,j-1,ind+1);
        visited[i][j] = false;
        return res;
    }
}
