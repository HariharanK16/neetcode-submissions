class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(
            Comparator.comparingInt(Pair<Integer, Integer>::getValue)
        );
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            Pair<Integer,Integer> pair = new Pair<>(entry.getKey(),entry.getValue());
            pq.add(pair);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[] res = new int[k];
        while(--k>=0){
            res[k] = pq.poll().getKey();
        }
        return res;
    }
}
