class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(n!=m){
            return false;
        }
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i<n;i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)-1);
        }
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            if(entry.getValue()!=0){
                return false;
            }
        }
        return true;
    }
}
