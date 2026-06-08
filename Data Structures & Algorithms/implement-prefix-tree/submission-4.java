class Trie {
    boolean eow;
    Map<Character,Trie> nodemap;
    public Trie(){
        this.eow = false;
        this.nodemap = new HashMap();
    }
    
}
class PrefixTree {

    Trie root;

    public PrefixTree() {
         root = new Trie();
    }

    public void insert(String word) {
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

    public boolean search(String word) {
        Trie temp = root;

        for(char c:word.toCharArray()){
            if(!temp.nodemap.containsKey(c)){
                return false;
            }
            temp = temp.nodemap.get(c);
        }
        return temp.eow;
    }

    public boolean startsWith(String prefix) {
        Trie temp = root;

        for(char c:prefix.toCharArray()){
            if(!temp.nodemap.containsKey(c)){
                return false;
            }
            temp = temp.nodemap.get(c);
        }
        return true;
    }
}
