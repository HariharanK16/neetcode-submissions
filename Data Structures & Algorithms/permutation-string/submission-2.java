class Solution {
    HashMap<Character,Integer> map;
    public int compareString(String s) {
        int ind = 0;
        int n = s.length();
        HashMap<Character,Integer> temp = new HashMap<>();
        for(int i = 0;i<n;i++){
            temp.put(s.charAt(i),temp.getOrDefault(s.charAt(i),0)+1);
            if(!map.containsKey(s.charAt(i))){
                return i;
            }
            else if(temp.get(s.charAt(i))>map.get(s.charAt(i))){
                return -1;
            }
        }
        return 0;
    }
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if(n>m){
            return false;
        }
        map = new HashMap<>();
        for(int i = 0;i<n;i++){
            map.put(s1.charAt(i),map.getOrDefault(s1.charAt(i),0)+1);
        }
        
        for(int i = 0;i<m;i++){
            if(map.containsKey(s2.charAt(i))){
                if(i+n<=m){
                    String sub = s2.substring(i,i+n);
                    int ind = compareString(sub);
                    if(ind==0){
                        return true;
                    }
                    if(ind>0){
                        i = i+ind-1;
                    } 
                }
            }
        }
        return false;
    }
}
