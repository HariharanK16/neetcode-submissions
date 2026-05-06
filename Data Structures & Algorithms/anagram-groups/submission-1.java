class Solution {

    public String sortAString(String value){
        int map[] = new int[26];
        for(char c : value.toCharArray()){
            map[c-'a']++;
        }
        return Arrays.toString(map).replaceAll(",","");
    }

    public List<List<String>> getListofStringList(HashMap<String,List<String>> map){
        List<List<String>> list = new ArrayList<>();
        for(Map.Entry<String,List<String>> entry : map.entrySet()){
            list.add(entry.getValue());
        }
        return list;
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        HashMap<String,List<String>> map = new HashMap<>();

        for(int i = 0;i<n;i++){
            String stringSorted = sortAString(strs[i]);
            if(map.containsKey(stringSorted)){
                List<String> list = map.get(stringSorted);
                list.add(strs[i]);
                map.put(stringSorted,list);
            }
            else{
                List<String> ls = new ArrayList<String>();
                ls.add(strs[i]);
                map.put(stringSorted,ls);
            }
        }

        return getListofStringList(map);
    }
}
