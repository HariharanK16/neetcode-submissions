class Solution {
    public boolean compareMaps(Map<Character,Integer> map, Map<Character,Integer> temp) {
                                    System.out.println("temp-"+temp);
                            System.out.println("map-"+map);
        System.out.println("ms-"+map.size());
        System.out.println("ts-"+temp.size());
        if(map.size()!=temp.size()){
            return false;
        }
        for(Map.Entry<Character,Integer> entry : temp.entrySet()){
                    System.out.println("ev-"+entry.getValue());
        System.out.println("ek-"+entry.getKey());
            if(entry.getValue()<map.get(entry.getKey())){
                return false;
            }
        }
        return true;
    }
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        Map<Character,Integer> map = new HashMap<>();

        for(int i = 0;i<m;i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        }

        int l = 0;
        int min = Integer.MAX_VALUE;
        String res = "";
        for(int r = 0;r<n;r++){
            if(map.containsKey(s.charAt(r))){
                Map<Character,Integer> temp = new HashMap<>();
                while(r<n){
                    if(map.containsKey(s.charAt(r))){
                        temp.put(s.charAt(r),temp.getOrDefault(s.charAt(r),0)+1);
                        // if(temp.get(s.charAt(r))>map.get(s.charAt(r))){
                        //     while(temp.get(s.charAt(r))>map.get(s.charAt(r))){
                        //         if(temp.containsKey(s.charAt(l))){
                        //             temp.put(s.charAt(l),temp.get(s.charAt(l))-1);
                        //         }
                        //         l++;
                        //     }
                        // }
                        boolean check = compareMaps(map,temp);
                        if(check){
                            while(!temp.containsKey(s.charAt(l)) || temp.get(s.charAt(l)) > map.get(s.charAt(l))){
                                if(temp.containsKey(s.charAt(l))) {
                                    temp.put(s.charAt(l),temp.get(s.charAt(l))-1);
                                }
                                l++;
                            }
                            String val = s.substring(l,r+1);
                            int size = val.length();
                            if(size<min){
                                min = size;
                                res = val;
                            }

                            System.out.println("res-"+res);
                            System.out.println("val-"+val);
                            System.out.println(temp.equals(map));
                            // break;
                        }
                    }
                    r++;
                }
            }
        }

        System.out.println(map);
        return res;
    }
}
