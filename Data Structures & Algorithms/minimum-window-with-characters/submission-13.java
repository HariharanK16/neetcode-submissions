class Solution {
    public String minWindow(String s, String t) {
        int n = s.length(), m = t.length();
        if(m == 0 || m>n){
            return "";
        }
        Map<Character,Integer> count = new HashMap<>();

        for(Character c : t.toCharArray()){
            count.put(c,count.getOrDefault(c,0)+1);
        }
        
        Map<Character,Integer> window = new HashMap<>();

        int i = 0, j = 0;
        int l = -1, r = -1;
        int have = 0;
        int resLen = Integer.MAX_VALUE;
        int need = count.size();
        while(j<n){
            window.put(s.charAt(j), window.getOrDefault(s.charAt(j),0)+1);
            if(count.containsKey(s.charAt(j)) && count.get(s.charAt(j)).equals(window.get(s.charAt(j)))){
                have++;
            } 
            while(have == need){
                if(resLen>j-i+1){
                    resLen = j - i + 1;
                    l = i;
                    r = j+1;
                }
                window.put(s.charAt(i),window.get(s.charAt(i))-1);
                if(count.containsKey(s.charAt(i)) && count.get(s.charAt(i)) > window.get(s.charAt(i))){
                    have--;
                }
                i++;
            }
            j++;
        }
        return resLen == Integer.MAX_VALUE ? "" : s.substring(l,r);
    }
}
