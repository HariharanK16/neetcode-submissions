class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int output = 0;
        int max = 0;
        int i = 0, j = 0;
                    int maxf = 0;
        while(j<n){
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);

            // for(Map.Entry<Character,Integer> entry: map.entrySet()){
                maxf = Math.max(maxf,map.get(s.charAt(j)));
            // }

            while((j-i+1)-maxf>k){
                map.put(s.charAt(i), map.get(s.charAt(i))-1);
                i++;
            }
            output = Math.max(output, j-i+1);
            j++;
        }
        return output;
    }
}
