class Solution {

    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if(n > m){
            return false;
        }

        HashMap<Character, Integer> count = new HashMap<>();

        for(Character c : s1.toCharArray()){
            count.put(c,count.getOrDefault(c,0)+1);
        }

        int i = 0, j = 0;

        while(j<m){
            
            if(count.containsKey(s2.charAt(j)) && j+n<=m){
                i = j;
                HashMap<Character, Integer> count2 = new HashMap<>();
                String sub = s2.substring(j,j+n);
                int size = sub.length(), k = 0;
                while(k<size){
                    count2.put(sub.charAt(k), count2.getOrDefault(sub.charAt(k),0)+1);
                    if(!count.containsKey(sub.charAt(k)) || count.get(sub.charAt(k))<count2.get(sub.charAt(k))){
                        break;
                    }
                    k++;
                }
                if(k==size){
                    return true;
                }
            }
            j++;

        }
        return false;
    }
}
