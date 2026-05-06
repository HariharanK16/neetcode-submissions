class Solution {
    private String genKey(String str){
        int map[] = new int[26];
        for(char c : str.toCharArray()){
            map[c-'a']++;
        }
        return Arrays.toString(map);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();

        for(int i = 0; i<strs.length;i++){
            String key = genKey(strs[i]);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
}
