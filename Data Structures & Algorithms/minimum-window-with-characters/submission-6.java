class Solution {
    public boolean compareMaps(Map<Character,Integer> map, Map<Character,Integer> temp) {
        if(map.size()!=temp.size()){
            return false;
        }
        for(Map.Entry<Character,Integer> entry : temp.entrySet()){
            if(entry.getValue()<map.get(entry.getKey())){
                return false;
            }
        }
        return true;
    }
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        Map<Character,Integer> map = new HashMap<>();
                        Map<Character,Integer> temp = new HashMap<>();
        for(int i = 0;i<m;i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        }
        int l = 0, r = 0;
        int min = Integer.MAX_VALUE;
        String res = "";
        while(r<n){
            if(map.containsKey(s.charAt(r))){
                temp.put(s.charAt(r),temp.getOrDefault(s.charAt(r),0)+1);
                if(compareMaps(map,temp)){
                    while(!temp.containsKey(s.charAt(l)) || temp.get(s.charAt(l)) > map.get(s.charAt(l))){
                        if(temp.containsKey(s.charAt(l))) {
                            temp.put(s.charAt(l),temp.get(s.charAt(l))-1);
                        }
                        l++;
                    }
                    if(r-l+1<min){
                        min = r-l+1;
                        res = s.substring(l,r+1);;
                    }
                }
            }
            r++;
        }
        return res;
    }
}
