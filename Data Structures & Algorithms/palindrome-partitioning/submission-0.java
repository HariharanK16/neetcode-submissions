class Solution {
    List<List<String>> res = new ArrayList<>();
    List<String> sub = new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(s,0);
        return res;
    }

    private void dfs(String s, int i){
        if(i >= s.length()){
            res.add(new ArrayList<>(sub));
            return;
        }

        for(int j = i;j<s.length();j++){
            if(isPali(s,i,j)){
                sub.add(s.substring(i,j+1));
                dfs(s,j+1);
                sub.remove(sub.size()-1);
            }
        }
    }
private boolean isPali(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
