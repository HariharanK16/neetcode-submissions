class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;
        Map<Integer,Integer> map = new HashMap<>();

        for(int num:hand){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(map.keySet());

        while(!pq.isEmpty()){
            int num = pq.peek();

            for(int i = num;i<num+groupSize;i++){
                if(!map.containsKey(i)) return false;

                map.put(i, map.get(i)-1);
                if(map.get(i)==0) pq.poll();
            }
        }
        return true;
    }
}
