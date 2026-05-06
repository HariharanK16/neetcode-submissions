class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer,Set<Character>> row = new HashMap<>();
        Map<Integer,Set<Character>> col = new HashMap<>();
        Map<String,Set<Character>> square = new HashMap<>();


        int ROWS = board.length;
        int COLS = board[0].length;

        for(int r = 0;r<ROWS;r++){
            for(int c = 0;c<COLS;c++){
                if(board[r][c] == '.') continue;

                row.putIfAbsent(r,new HashSet<>());
                col.putIfAbsent(c,new HashSet<>());

                String s = r/3 + " " +c/3;
                square.putIfAbsent(s, new HashSet<>());

                if(row.get(r).contains(board[r][c]) || col.get(c).contains(board[r][c]) || square.get(s).contains(board[r][c])) return false;

                row.get(r).add(board[r][c]);
                col.get(c).add(board[r][c]);
                square.get(s).add(board[r][c]);
            }
        }
        return true;
    }
}
