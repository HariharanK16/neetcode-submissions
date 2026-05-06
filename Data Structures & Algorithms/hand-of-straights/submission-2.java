class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : hand){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        PriorityQueue<Integer> pr = new PriorityQueue<>(map.keySet());
        while(!pr.isEmpty()){
            int first = pr.peek();
            for(int i = first;i<first+groupSize;i++){
                if(!map.containsKey(i)){
                    return false;
                }
                map.put(i,map.get(i)-1);
                if(map.get(i)==0){
                    // if(i != pr.peek()){
                    //     return false;
                    // }
                    pr.poll();
                }
            }
        }
        return true;
    }
}
