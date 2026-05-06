class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer,Set<Character>> rows = new HashMap<>();
        Map<Integer,Set<Character>> cols = new HashMap<>();
        Map<String,Set<Character>> squares = new HashMap<>();

        int ROWS = board.length;
        int COLS = board[0].length;

        for(int i = 0;i<ROWS;i++){
            for(int j = 0;j<COLS;j++){
                if (board[i][j] == '.') continue;

                rows.putIfAbsent(i,new HashSet<>());
                cols.putIfAbsent(j,new HashSet<>());
                String square = (i/3) + ","+ (j/3);
                squares.putIfAbsent(square,new HashSet<>());

                if(rows.get(i).contains(board[i][j]) || cols.get(j).contains(board[i][j]) || squares.get(square).contains(board[i][j])){
                    return false;
                }
                rows.get(i).add(board[i][j]);
                cols.get(j).add(board[i][j]);
                squares.get(square).add(board[i][j]);
            }
        }
        return true;
    }
}
