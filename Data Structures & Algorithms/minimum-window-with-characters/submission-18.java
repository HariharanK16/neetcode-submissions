class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();

        if(n<m) return "";

        Map<Character,Integer> count1 = new HashMap();

        for(char c:t.toCharArray()){
            count1.put(c,count1.getOrDefault(c,0)+1);
        }

        int i = 0, j = 0, l = 0, r = 0, resLen = Integer.MAX_VALUE;
        int have = 0, need = count1.size();
        Map<Character,Integer> count2 = new HashMap();
        while(r<s.length()){
            char c = s.charAt(r);
            count2.put(c, count2.getOrDefault(c, 0)+1);

            if(count1.containsKey(c) && count1.get(c).equals(count2.get(c))){
                have++;
            }

            while(have == need){
                if(resLen>r-l+1){
                    resLen = r - l + 1;
                    i = l;
                    j = r + 1;
                }
                char v = s.charAt(l);
                count2.put(v,count2.get(v)-1);
                if(count1.containsKey(v) && count1.get(v) > count2.get(v)){
                    have--;
                }
                l++;
            }
            r++;
        }
        return resLen == Integer.MAX_VALUE ? "" : s.substring(i,j);
    }
}
