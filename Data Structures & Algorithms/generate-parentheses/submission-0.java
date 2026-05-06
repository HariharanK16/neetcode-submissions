class Solution {
    List<String> list;
    public List<String> generateParenthesis(int n) {
        // char open = "(", close = ")";
        list = new ArrayList<>();

        createString("",n,n);
        return list;
    }
    private void createString(String s, int open, int close) {
        if(close == 0){
            list.add(s);
            return;
        }
        if(open>0){
            createString(s+"(",open-1,close);
        }
        if(open<close){
            createString(s+")",open,close-1);
        }
    }
}
