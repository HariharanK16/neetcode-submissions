class Solution {
    Set<Integer> colPos = new HashSet<>();
    Set<Integer> posDiag = new HashSet<>();
    Set<Integer> negDiag = new HashSet<>();
    List<List<String>> res = new ArrayList<>();
    char[][] board;
    public List<List<String>> solveNQueens(int n) {
        board = new char[n][n];
        for(char[] b:board){
            Arrays.fill(b,'.');
        }
        dfs(0,n);
        return res;
    }
    public void dfs(int i, int n){
        if(i==n){
            List<String> list = new ArrayList<>();
            for(char[] b:board) list.add(new String(b));
            res.add(list);
            return;
        }
        for(int j = 0;j<n;j++){
            if(colPos.contains(j) || posDiag.contains(i+j) || negDiag.contains(i-j)){
                continue;
            }
            colPos.add(j);
            posDiag.add(i+j);
            negDiag.add(i-j);
            board[i][j]='Q';
            dfs(i+1,n);
            colPos.remove(j);
            posDiag.remove(i+j);
            negDiag.remove(i-j);
            board[i][j]='.';
        }
    }
}
