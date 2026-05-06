class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue<>((a,b) -> b.getKey() - a.getKey());
        int[] arr = new int[n-k+1];
        int ind = 0;
        int l = 0;
        for(int r = 0;r<n;r++){
            pq.add(new Pair<Integer,Integer>(nums[r],r));
            if(r-l+1==k){
                while(pq.peek().getValue()<l){
                    pq.poll();
                }
                arr[ind++]=pq.peek().getKey();
                l++;
            }
        }
        return arr;
    }
}
