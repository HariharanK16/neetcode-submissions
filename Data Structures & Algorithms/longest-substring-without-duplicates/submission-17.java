class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r= 0;
        Set<Character> set = new HashSet<>();
        int max = 0;
        while(r<s.length()){
            if(set.contains(s.charAt(r))){
                set.remove(s.charAt(l++));
                continue;
            }
            set.add(s.charAt(r));
            max = Math.max(max,set.size());
            r++;
        }
        return max;
    }
}
