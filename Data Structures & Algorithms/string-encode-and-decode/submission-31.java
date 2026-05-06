class Solution {

    public String encode(List<String> strs) {
        StringBuilder sbr = new StringBuilder("");
        for(String str:strs){
            sbr.append(str.length()).append("#").append(str);
        }
        return sbr.toString();
    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<>();
        int n = str.length();
        for(int i = 0;i<n;i++){
            int delimiter = str.indexOf("#",i);
            int len = Integer.parseInt(str.substring(i,delimiter));
            strs.add(str.substring(delimiter+1,delimiter+1+len));
            i = delimiter+len;
        }
        return strs;
    }
}
