class Solution {
    private String hashCode(String value){
        int hash[] = new int[26];
        for(char c:value.toCharArray()){
            hash[c-'a']++;
        }
        return Arrays.toString(hash);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str:strs){
            String strHash = hashCode(str);
            map.putIfAbsent(strHash, new ArrayList<>());
            map.get(strHash).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
