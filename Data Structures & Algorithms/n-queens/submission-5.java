class Solution {
    Set<Integer> col = new HashSet<>();
    Set<Integer> pd = new HashSet<>();
    Set<Integer> cd = new HashSet<>();

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        bt(board, 0, n);    
        return res;
    }

    private void bt(char[][] board, int ind, int n){
        if(ind==n){
            List<String> list = new ArrayList<>();
            for(char[] b:board) list.add(new String(b));
            res.add(list);
            return;
        }

        for(int i = 0;i<n;i++){
            if(col.contains(i) || pd.contains(i+ind) || cd.contains(ind - i)) continue;

            board[ind][i] = 'Q';
            col.add(i);
            pd.add(ind + i);
            cd.add(ind - i);
            bt(board,ind+1,n);
            board[ind][i] = '.';
            col.remove(i);
            pd.remove(ind + i);
            cd.remove(ind - i);
        }
    }
}
