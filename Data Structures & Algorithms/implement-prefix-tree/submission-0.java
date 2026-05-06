public class TrieNode {
    boolean eow;
    HashMap<Integer,TrieNode> nodeMap;
    public TrieNode() {
        eow = false;
        nodeMap = new HashMap<>();
    }
};

class PrefixTree {

    TrieNode root;

    public PrefixTree() {
         root = new TrieNode();
    }

    public void insert(String word) {
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
        TrieNode temp = root;
        for(char c : word.toCharArray()){
            if(!temp.nodeMap.containsKey(c-'a')){
                return false;
            }
            temp = temp.nodeMap.get(c-'a');
        }
        return temp.eow;
    }

    public boolean startsWith(String word) {
        TrieNode temp = root;
        for(char c : word.toCharArray()){
            if(temp.nodeMap.containsKey(c-'a')){
                temp = temp.nodeMap.get(c-'a');
            } else {
                return false;
            }
        }

        return true;
    }
}
