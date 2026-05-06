class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0;
        Map<Character,Integer> counter = new HashMap<>();

        int output = 0;
        while(r<s.length()){
            counter.put(s.charAt(r),counter.getOrDefault(s.charAt(r),0)+1);
            Collection<Integer> counts = counter.values();
            int maxf = 0;
            for(Integer count:counts){
                maxf = Math.max(maxf,count);
            }

            while((r-l+1)-maxf>k){
                counter.put(s.charAt(l),counter.get(s.charAt(l))-1);
                l++;
            }
            output = Math.max(output,r-l+1);
            r++;
        }
        return output;
    }
}
