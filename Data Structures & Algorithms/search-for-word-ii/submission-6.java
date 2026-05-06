public class TrieNode {
    boolean eow;
    HashMap<Integer,TrieNode> nodeMap;
    public TrieNode() {
        eow = false;
        nodeMap = new HashMap<>();
    }
};

class Solution {
    int ROW,COL;
    Set<String> res;
    TrieNode root;
    public List<String> findWords(char[][] board, String[] words) {
        ROW = board.length; COL = board[0].length;
        root = new TrieNode();
        res = new HashSet<>();

        for(String word:words){
            insert(word);
        }

        for(int  i = 0;i<ROW;i++){
            for(int j = 0;j<COL;j++){
                findTrieNode(board,i,j,"",root);
            }
        }


        return new ArrayList<String>(res);
        

    }

    private void findTrieNode(char[][] board, int r, int c, String word,TrieNode node){
        if(r>=ROW || r<0 || c >= COL || c<0 || board[r][c] == '.' || !node.nodeMap.containsKey(board[r][c]-'a')){
            return;
        }
        
        
        node = node.nodeMap.get(board[r][c]-'a');
        word = word+board[r][c];
        char temp = board[r][c];
        board[r][c] = '.';
        if(node.eow){
            res.add(word);
        }
        findTrieNode(board,r+1,c,word,node);
        findTrieNode(board,r-1,c,word,node);
        findTrieNode(board,r,c+1,word,node);
        findTrieNode(board,r,c-1,word,node);
        board[r][c] = temp;
        return;
    }

    private void insert(String word) {
        TrieNode temp = root;
        for(char c : word.toCharArray()){
            if(!temp.nodeMap.containsKey(c-'a')){
                TrieNode newVal = new TrieNode();
                temp.nodeMap.put(c-'a',newVal);
                
            }
            temp = temp.nodeMap.get(c-'a');
        }
        temp.eow = true;
    }
}
