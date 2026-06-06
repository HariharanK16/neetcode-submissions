class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if(m<n){
            return false;
        }

        Map<Character,Integer> counter = new HashMap<>();

        for(char c:s1.toCharArray()){
            counter.put(c,counter.getOrDefault(c,0)+1);
        }

        int need = counter.size();
        

        for(int r = 0;r<(s2.length()-s1.length())+1;r++){
            Map<Character,Integer> haver = new HashMap<>();
            int have = 0;
            int l = r;
            while(l<r+n){
                if(!counter.containsKey(s2.charAt(l))) break;

                haver.put(s2.charAt(l), haver.getOrDefault(s2.charAt(l),0)+1);
                if(haver.get(s2.charAt(l))>counter.get(s2.charAt(l))) break;

                if(haver.get(s2.charAt(l))==counter.get(s2.charAt(l))) have++;
                l++;
            }
            if(have == need) return true;

        }
        return false;
    }
}
