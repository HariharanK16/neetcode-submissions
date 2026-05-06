class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int output = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int sp = 0, ep = 0;
        while(ep<n){
            if(map.containsKey(s.charAt(ep))) {

                int ind = map.get(s.charAt(ep));
                output = Math.max(output, map.size());
                sp = ind+1;
                map.clear();
                ep = sp;
            } else {
                
                map.put(s.charAt(ep),ep);
                ep++;
            }

        }
                System.out.println(map);
        return Math.max(output, map.size());
    }
}
