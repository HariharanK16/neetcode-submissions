class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(
            Comparator.comparingInt(Pair<Integer, Integer>::getValue).reversed()
        );
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            Pair<Integer,Integer> pair = new Pair<>(entry.getKey(),entry.getValue());
            pq.add(pair);
        }
        int[] res = new int[k];
        while(k>0){
            res[k-1] = pq.poll().getKey();
            k--;
        }
        return res;
    }
}
