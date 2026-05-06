public class Trie {
    boolean eow;
    HashMap<Character,Trie> nodemap;
    public Trie() {
        eow = false;
        nodemap = new HashMap<>();
    }
};

class Solution {
    Trie root;
    public List<String> findWords(char[][] board, String[] words) {
        int ROW = board.length;
        int COL = board[0].length;

        root = new Trie();
        for(String word:words){
            insert(word);
        }
        Set<String> set = new HashSet<>();
        for(int r = 0;r<ROW;r++){
            for(int c = 0;c<COL;c++){
                findAllWords(board,r,c,"",set, root);
            }
        }
        return new ArrayList<>(set);
    }

    private void findAllWords(char[][] board, int r, int c, String word, Set<String> set, Trie temp){
        if(r<0 || r>=board.length || c<0 || c>=board[0].length || board[r][c] =='.' ||!temp.nodemap.containsKey(board[r][c])){
            return;
        }

        char t = board[r][c];
        board[r][c] = '.';
        temp = temp.nodemap.get(t);
        if(temp.eow == true){
            set.add(word+t);
        }
        findAllWords(board,r+1,c,word+t,set,temp);
        findAllWords(board,r-1,c,word+t,set,temp);
        findAllWords(board,r,c+1,word+t,set,temp);
        findAllWords(board,r,c-1,word+t,set,temp);

        board[r][c] = t;

    }

    private void insert(String word){
        Trie temp = root;

        for(char c:word.toCharArray()){
            if(!temp.nodemap.containsKey(c)){
                Trie newNode = new Trie();
                temp.nodemap.put(c,newNode);
            }
            temp = temp.nodemap.get(c);
        }
        temp.eow = true;
    }
}
