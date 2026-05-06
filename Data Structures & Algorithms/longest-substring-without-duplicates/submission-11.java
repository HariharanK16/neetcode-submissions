class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int output = 0;
        HashSet<Character> set = new HashSet<>();
        int sp = 0, ep = 0;
        while(ep<n){
            while(set.contains(s.charAt(ep))){
                set.remove(s.charAt(sp));
                sp++;
            }
            set.add(s.charAt(ep));
            ep++;
            output = Math.max(output, set.size());
        }
        return output;
    }
}
