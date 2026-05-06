class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer,Set<Character>> rowMap = new HashMap<>();
        Map<Integer,Set<Character>> colMap = new HashMap<>();
        Map<String,Set<Character>> squareMap = new HashMap<>();

        int ROW = board.length;
        int COL = board[0].length;

        for(int i = 0;i<ROW;i++){
            for(int j = 0;j<COL;j++){
                if (board[i][j] == '.') continue;

                rowMap.putIfAbsent(i, new HashSet<>());
                colMap.putIfAbsent(j, new HashSet<>());
                String square = (i/3)+" "+(j/3);
                squareMap.putIfAbsent(square, new HashSet<>());

                if(rowMap.get(i).contains(board[i][j]) || colMap.get(j).contains(board[i][j]) || squareMap.get(square).contains(board[i][j])){
                    return false;
                }

                rowMap.get(i).add(board[i][j]);
                colMap.get(j).add(board[i][j]);
                squareMap.get(square).add(board[i][j]);
            }
        }

        return true;

    }
}
