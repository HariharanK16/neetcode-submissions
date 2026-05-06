public class Trie {
    boolean eow;
    HashMap<Character,Trie> nodemap;
    public Trie() {
        eow = false;
        nodemap = new HashMap<>();
    }
};

class WordDictionary {
    Trie root;
    public WordDictionary() {
        root = new Trie();
    }

    public void addWord(String word) {
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
        return dfs(word,0,root);
    }

    private boolean dfs(String word, int ind, Trie root){
        Trie temp = root;

        for(int i = ind;i<word.length();i++){
            if(word.charAt(i)=='.'){
                for(Map.Entry<Character,Trie> entry:temp.nodemap.entrySet()){
                    if(dfs(word,i+1,entry.getValue())){
                        return true;
                    }
                }
                return false;
            }else{
                if(!temp.nodemap.containsKey(word.charAt(i))){
                    return false;
                }
                temp = temp.nodemap.get(word.charAt(i));
            }

        }
        return temp.eow;
    }
}
