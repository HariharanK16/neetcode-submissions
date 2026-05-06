class Solution {
    Set<Integer> col;
    Set<Integer> posDiag;
    Set<Integer> negDiag;
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        col = new HashSet<>();
        posDiag = new HashSet<>();
        negDiag = new HashSet<>();
        res = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i = 0;i< n;i++){
            for(int j = 0;j< n;j++){
                board[i][j] = '.';
            }
        }

        nqueens(board,0,n);
        return res;

    }

    private void nqueens(char[][] board, int r, int n){
        if(r ==n){
            List<String> list = new ArrayList<>();
            for(int i = 0;i<n;i++){
                list.add(new String(board[i]));
            }
            res.add(list);
            return;
        }

        for(int c = 0;c<n;c++){
            if(col.contains(c) || posDiag.contains(r+c) || negDiag.contains(r-c)){
                continue;
            }

            col.add(c);
            posDiag.add(r+c);
            negDiag.add(r-c);
            board[r][c] = 'Q';
            nqueens(board,r+1,n);
            col.remove(c);
            posDiag.remove(r+c);
            negDiag.remove(r-c);
            board[r][c] = '.';
        }
    }
}
