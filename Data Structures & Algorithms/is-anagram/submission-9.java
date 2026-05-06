class Solution {
    private String hashCode(String value){
        int hash[] = new int[26];
        for(char c:value.toCharArray()){
            hash[c-'a']++;
        }
        return Arrays.toString(hash);
    }
    public boolean isAnagram(String s, String t) {
        return hashCode(s).equals(hashCode(t));
    }
}
