class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(n<m) return "";


        Map<Character,Integer> counter = new HashMap<>();

        for(char c: t.toCharArray()) {
            counter.put(c,counter.getOrDefault(c,0)+1);
        }

        int need = counter.size();
        Map<Character,Integer> haver = new HashMap<>();
        int have = 0;
        int l = 0, i = 0, j = 0, resLen = Integer.MAX_VALUE;
        for(int r = 0;r<n;r++){
            char c = s.charAt(r);

            haver.put(c,haver.getOrDefault(c,0)+1);

            if(counter.containsKey(c) && counter.get(c).equals(haver.get(c))){
                have++;
            }

            while(have == need){
                if(r - l + 1 < resLen){
                    resLen = r - l + 1;
                    i = l;
                    j = r + 1;
                }
                char q = s.charAt(l);
                haver.put(  q,haver.get(q)-1);

                if(counter.containsKey(q) && counter.get(q) > haver.get(q)){
                    have--;
                }
                l++;
                
            }
            
        }
        return  resLen == Integer.MAX_VALUE ? "" : s.substring(i,j);
    }
}
