class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if(n==0){
            return res;
        }
        generate("",n,n);
        return res;
    }
    public void generate(String s, int open, int close){
        if(close==0){
            res.add(s);
            return;
        }
        if(open>0){
            generate(s+"(",open-1,close);
        }
        if(close>open){
            generate(s+")",open,close-1);
        }
    }
}
