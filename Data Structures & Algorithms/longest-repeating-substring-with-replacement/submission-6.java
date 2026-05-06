class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> map = new HashMap<>();
        int n = s.length();
        int i = 0, j = 0;

        int output = 0, maxf = 0;
        while(j<n){
           map.put(s.charAt(j), map.getOrDefault(s.charAt(j),0)+1);
            Collection<Integer> counts = map.values();

            for (Integer count : counts) {
                maxf = Math.max(maxf,count);
            }
        //    maxf = Math.max(maxf,map.get(s.charAt(j)));

           while((j-i+1)-maxf > k){
            map.put(s.charAt(i),map.get(s.charAt(i))-1);
            i++;
           }
           output = Math.max(output, j-i+1);
           j++;
        }
        return output;
    }
}
