class Solution {

    public String encode(List<String> strs) {
        if(strs.size() == 0)
            return "";
        return String.join("-_-", strs)+"-_-";

    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<String>();
        if(str.isEmpty())
            return strs;
        if(str.equals("-_-")){
           strs.add("");
           return strs;
        } 

        return Arrays.stream(str.split("-_-")).toList();
    }
}
