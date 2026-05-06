class Solution {
    private String hashCode(String str){
        int[] hash = new int[26];
        for(char c: str.toCharArray()){
            hash[c-'a']++;
        }
        return Arrays.toString(hash);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();

        for(String str:strs){

            String hash = hashCode(str);
            map.putIfAbsent(hash, new ArrayList<>());
            map.get(hash).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
