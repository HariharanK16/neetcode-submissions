class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue<>((a,b) -> b.getKey() - a.getKey());
        ArrayList<Integer> list = new ArrayList<>();

        int l = 0;
        for(int r = 0;r<n;r++){
            pq.add(new Pair<Integer,Integer>(nums[r],r));
            if(r-l+1==k){
                System.out.println(pq.peek());
                while(pq.peek().getValue()<l){
                    pq.poll();
                }
                list.add(pq.peek().getKey());
                l++;
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
