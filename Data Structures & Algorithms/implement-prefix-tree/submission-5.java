class Trie {
    boolean eow;
    Map<Character,Trie> trie;
    public Trie(){
        eow = false;
        trie = new HashMap<>();
    }
}
class PrefixTree {

    Trie root;
    public PrefixTree() {
         root = new Trie();
    }



    public void insert(String word) {
        Trie temp = root;

        for(char c : word.toCharArray()){
            if(!temp.trie.containsKey(c)){
                Trie node = new Trie();
                temp.trie.put(c,node);
            }
            temp = temp.trie.get(c);
        }
        temp.eow = true;
    }

    public boolean search(String word) {
        Trie temp = root;

        for(char c: word.toCharArray()){
            if(!temp.trie.containsKey(c)) return false;
            temp = temp.trie.get(c);
        }
        return temp.eow;
    }

    public boolean startsWith(String word) {
        Trie temp = root;
        for(char c: word.toCharArray()){
            if(!temp.trie.containsKey(c)) return false;
            temp = temp.trie.get(c);
        }
        return true;
    }
}
