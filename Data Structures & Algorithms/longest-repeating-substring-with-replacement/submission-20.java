class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0;

        Map<Character,Integer> counter = new HashMap<>();
        int output = 0;

        while(r<s.length()){
            counter.put(s.charAt(r),counter.getOrDefault(s.charAt(r),0)+1);
            int maxF = 0;

            for(int count:counter.values()){
                maxF = Math.max(maxF,count);
                
            }
            while((r-l+1)-maxF>k){
                counter.put(s.charAt(l),counter.get(s.charAt(l))-1);
                l++;
            }
            output = Math.max(output,r-l+1);
            r++;
        }

        return output;
        
    }
}
