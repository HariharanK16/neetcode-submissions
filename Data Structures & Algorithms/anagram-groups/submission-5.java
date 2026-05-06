class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String,List<String>> map = new HashMap<>();

        for(String str: strs){
            int key[] = new int[26];
            for(char c :  str.toCharArray()){
                key[c-'a']++;
            }
            String hash = Arrays.toString(key);
            map.putIfAbsent(hash, new ArrayList<>());
            map.get(hash).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
