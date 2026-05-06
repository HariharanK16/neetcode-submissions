class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0 ;
        Map<Character,Integer> counter = new HashMap<>();

        int n = s.length();
        int maxFreq = 0;
        int output = 0;
        while(r<n){
            counter.put(s.charAt(r),counter.getOrDefault(s.charAt(r),0)+1);
            maxFreq = Math.max(maxFreq, counter.get(s.charAt(r)));

            while((r-l+1)-maxFreq>k){
                counter.put(s.charAt(l),counter.get(s.charAt(l))-1);
                l++;
            }
            output = Math.max(output,r-l+1);
            r++;
        }
        return output;
    }
}
