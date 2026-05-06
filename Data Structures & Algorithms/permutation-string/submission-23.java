class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        Map<Character,Integer> count1 = new HashMap<>();

        for(char c: s1.toCharArray()){
            count1.put(c, count1.getOrDefault(c, 0)+1);
        }

        int need = count1.size();
        for(int r= 0;r<(s2.length()-s1.length())+1;r++){
            int have = 0;
            int n = r+s1.length();
            Map<Character,Integer> count2 = new HashMap<>();
            for(int l = r;l<n;l++){
                char c = s2.charAt(l);
                if(!count1.containsKey(c)) break;
                count2.put(c, count2.getOrDefault(c, 0) + 1);
                if (count1.get(c) < count2.get(c)) {
                    break;
                }

                if (count1.get(c) == count2.get(c)) {
                    have++;
                }
                if(have == need) return true;
            }
        }
        return false;
    }
}
