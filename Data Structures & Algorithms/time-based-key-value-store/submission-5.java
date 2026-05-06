class TimeMap {

    Map<String,List<Pair<Integer, String>>> timeMap;
    public TimeMap() {
        this.timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        timeMap.putIfAbsent(key, new ArrayList<>());
        timeMap.get(key).add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        String res = "";
        List<Pair<Integer, String>> timestamps = timeMap.get(key);
        if(timestamps == null || timestamps.isEmpty()){
            return res;
        }

        int l = 0, r = timestamps.size() - 1;
        while(l<=r){
            int m = l + (r - l)/2;
            if(timestamps.get(m).getKey() <= timestamp){
                res = timestamps.get(m).getValue();
                l = m + 1;
            }
            else {
                r = m - 1;
            }
        }
        return res;
    }
}
