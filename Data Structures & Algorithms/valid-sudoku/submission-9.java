class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer,Set<Character>> rowPos = new HashMap<>();
        Map<Integer,Set<Character>> colPos = new HashMap<>();
        Map<String,Set<Character>> blockPos = new HashMap<>();

        int R = board.length;
        int C = board[0].length;
        for(int r = 0;r<R;r++){
            for(int c = 0;c<C;c++){
                if(board[r][c]=='.') continue;
                rowPos.putIfAbsent(r,new HashSet<>());
                colPos.putIfAbsent(c,new HashSet<>());
                String block = r/3+","+c/3;
                blockPos.putIfAbsent(block,new HashSet<>());

                if(rowPos.get(r).contains(board[r][c]) || colPos.get(c).contains(board[r][c]) || blockPos.get(block).contains(board[r][c])){
                    return false;
                }
                rowPos.get(r).add(board[r][c]);
                colPos.get(c).add(board[r][c]);
                blockPos.get(block).add(board[r][c]);

            }
        }
        return true;
    }
}
