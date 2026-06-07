class TimeMap {

    Map<String,List<Pair<Integer,String>>> map = new HashMap<>();
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair<>(timestamp,value));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        String s = "";
        List<Pair<Integer,String>> list = map.get(key);
        int r = list.size() - 1, l = 0;
        while(l<=r){
            int m = l + (r-l)/2;

            if(list.get(m).getKey() <= timestamp){
                s = list.get(m).getValue();
                l = m + 1;
            }else {
                r = m -1 ;
            }
        }
        return s;
    }
}
