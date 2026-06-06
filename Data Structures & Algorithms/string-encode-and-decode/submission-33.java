class Solution {

    public String encode(List<String> strs) {
        StringBuilder token = new StringBuilder("");
        for(String str:strs){
            token.append(str.length()+"#").append(str);
        }
        return token.toString();
    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<>();
        int n = str.length();
        for(int i = 0;i<n;){
            int split = str.indexOf("#",i);
            int length = Integer.parseInt(str.substring(i,split));
            String extracted = str.substring(split+1,split+1+length);
            strs.add(extracted);
            i = split+1+length;
        }
        return strs;
    }
}
