class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        dfs(s,res, new ArrayList(),0);
        return res;
    }

    private void dfs(String s, List<List<String>> res, List<String> sub, int ind){
        if(ind == s.length()){
            res.add(new ArrayList<>(sub));
        }

        for(int j = ind;j<s.length();j++){
            if(isPalindrome(s,ind,j)){
                sub.add(s.substring(ind,j+1));
                dfs(s,res,sub,j+1);
                sub.removeLast();
            }
        }
    }

    private boolean isPalindrome(String s, int l, int r){
        while(l<r){
            if(s.charAt(l) == (s.charAt(r))){
                l++;
                r--;
            }else return false;

        }
        return true;
    }
}
