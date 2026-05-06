class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();

        int n = s.length(), m = t.length();
        
        if(n!=m){
            return false;
        }

        for(int i = 0;i<n;i++){
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
