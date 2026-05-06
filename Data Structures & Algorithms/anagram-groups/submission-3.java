class Solution {

    public String sortAString(String value){
        int map[] = new int[26];
        for(char c : value.toCharArray()){
            map[c-'a']++;
        }
        return Arrays.toString(map);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        HashMap<String,List<String>> map = new HashMap<>();

        for(int i = 0;i<n;i++){
            String key = sortAString(strs[i]);
            map.putIfAbsent(key, new ArrayList<String>());
            map.get(key).add(strs[i]);

        }

        return new ArrayList<>(map.values());
    }
}
