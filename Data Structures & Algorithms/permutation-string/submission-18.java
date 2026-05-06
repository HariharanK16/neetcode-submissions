public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> count1 = new HashMap<>();
        for (char c : s1.toCharArray()) {
            count1.put(c, count1.getOrDefault(c, 0) + 1);
        }

        int need = count1.size();
        for (int i = 0; i < (s2.length()-s1.length())+1; i++) {
            char s = s2.charAt(i);
            if(count1.containsKey(s)){
                Map<Character, Integer> count2 = new HashMap<>();
                int have = 0;
                int n = i + s1.length();
                for(int j = i;j<n;j++){
                    char c = s2.charAt(j);
                    if(!count1.containsKey(c)){
                        break;
                    }
                    count2.put(c, count2.getOrDefault(c, 0) + 1);
                    if (count1.get(c) < count2.get(c)) {
                        break;
                    }

                    if (count1.get(c) == count2.get(c)) {
                        have++;
                    }
                    if (have == need) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}