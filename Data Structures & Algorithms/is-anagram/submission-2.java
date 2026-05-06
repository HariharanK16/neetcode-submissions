class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null || s.isEmpty() || t == null || t.isEmpty() || s.length()!=t.length()){
            return false;
        }
        int n = 0;
        int m = 0;
        int len = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<len;i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        }
        for(int j = 0; j<len;j++){
            map.put(t.charAt(j), map.getOrDefault(t.charAt(j),0)-1);
        }
        boolean anagram = true;
        for (Integer val : map.values()){
            if(val.intValue()!=0){
                anagram = false;
                break;
            }
}   
        return anagram;
    }
}
