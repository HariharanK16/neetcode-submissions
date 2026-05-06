class Solution {
    public String encode(List<String> strs) {
        if(strs.size() == 0)
            return "";
        return String.join("-_-", strs)+"-_-";
    }

    public List<String> decode(String str) {
        int i = 0, j = 0;
        int n = str.length();
        System.out.println(str);
        List<String> strs = new ArrayList<String>();
        if(n==0){
           return strs;
        }
        if(n <= 3){
           strs.add("");
           return strs;
        }
        while(j+3<n-3){
            if(str.substring(j,j+3).equals("-_-")){
                strs.add(str.substring(i,j));
                i = j+3;
            }
            j++;
        }
        strs.add(str.substring(i,n-3));
        return strs;
        
    }
}
