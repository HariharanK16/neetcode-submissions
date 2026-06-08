class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if(n==0) return res;
        bt("",n,n);
        return res;
    }

    private void bt(String s, int o, int c){
        if(c == 0){
            res.add(s);
            return;
        }
        if(o > 0) {
            bt(s+"(", o - 1, c);
        }
        if(c > o){
            bt(s+')', o , c-  1);
        }
    }
}
