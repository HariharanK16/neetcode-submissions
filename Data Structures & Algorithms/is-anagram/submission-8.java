class Solution {
    public String hashKey(String s){
        int[] hash = new int[26];
        for(char c:s.toCharArray()){
            hash[c-'a']++;
        }
        return Arrays.toString(hash);
    }
    public boolean isAnagram(String s, String t) {
        int n = s.length(), m = t.length();
        
        if(n!=m){
            return false;
        }
        System.out.println(hashKey(s)+" "+hashKey(t));
        return hashKey(s).equals(hashKey(t));
    }
}
