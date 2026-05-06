class TimeMap {

    Map<String,List<Pair<String, Integer>>> hashMap;
    public TimeMap() {
        hashMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Pair<String,Integer> pair = new Pair(value,timestamp);
        List<Pair<String,Integer>> list = hashMap.getOrDefault(key, new ArrayList<>());
        list.add(pair);
        hashMap.put(key,list);
    }
    
    public String get(String key, int timestamp) {
        List<Pair<String,Integer>> list = hashMap.getOrDefault(key, new ArrayList<>());
        int r = list.size() - 1, l = 0;
        String res = "";
        while(l<=r){
            int m = l+(r-l)/2;
            if(list.get(m).getValue()<=timestamp){
                res = list.get(m).getKey();
                l = m + 1;
            } else{
                r = m- 1;
            }
        }
        return res;
    }
}
