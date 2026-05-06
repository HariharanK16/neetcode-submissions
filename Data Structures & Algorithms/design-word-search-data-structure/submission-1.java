public class TrieNode {
    boolean eow;
    HashMap<Integer,TrieNode> nodeMap;
    public TrieNode() {
        eow = false;
        nodeMap = new HashMap<>();
    }
};


class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
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

    public boolean search(String word) {
        return dfs(word,0,root);
    }

    private boolean dfs(String word, int j, TrieNode root){
        TrieNode temp = root;
        for(int  i = j;i<word.length();i++){
            char c = word.charAt(i);
            if(c =='.'){
                for(Map.Entry<Integer,TrieNode> entry : temp.nodeMap.entrySet()){
                    if(dfs(word,i+1, entry.getValue())){
                        return true;
                    }
                }
                return false;
            } else {
                if(!temp.nodeMap.containsKey(c-'a')){
                    return false;
                }
                temp = temp.nodeMap.get(c-'a');
            }
        }
        return temp.eow;
    }
}
