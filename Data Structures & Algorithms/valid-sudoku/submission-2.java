class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Pair<Integer,Integer>, Character> map = new HashMap<>();
        for(int i = 0;i<9;i++){
            for(int j = 0;j<9;j++){
                if(board[i][j]!='.')
                    map.put(new Pair(i,j),board[i][j]);
            }
        }

        for(Map.Entry<Pair<Integer,Integer>, Character> entry : map.entrySet()){
            Pair<Integer,Integer> pair = entry.getKey();
            int row = pair.getKey();
            int col = pair.getValue();
            Character val = entry.getValue();
            for(int r = 0;r<9;r++){
                if(row == r || board[r][col] == '.')
                    continue;
                if(val == board[r][col]){
                    return false;
                }
            }
            for(int c = 0;c<9;c++){
                if(col == c || board[row][c] == '.')
                    continue;
                if(val == board[row][c]){
                    return false;
                }
            }

            int sr = (row/3)*3;
            int sc = (col/3)*3;
            for(int i = sr; i< sr+3;i++){
                for(int j = sc; j< sc+3; j++ ){
                    if((i==row && j==col) || board[i][j] == '.')
                        continue;
                    if(val == board[i][j]){
                        return false;
                    }

                }
            }

        }

        
        return true;
    }
}
