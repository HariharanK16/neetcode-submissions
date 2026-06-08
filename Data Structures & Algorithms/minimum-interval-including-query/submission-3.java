class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = intervals.length;
        int[] sq = Arrays.stream(queries).sorted().toArray();
        Map<Integer,Integer> map = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);

        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        int i = 0;
        for(int q:sq){
            while(i<n && intervals[i][0]<=q){
                int l = intervals[i][0];
                int r = intervals[i][1];
                pq.offer(new int[]{r-l+1,r});
                i++;
            }
            while(!pq.isEmpty() && pq.peek()[1]<q){
                pq.poll();
            }
            map.put(q, pq.isEmpty() ? -1 : pq.peek()[0]); 
        }

        int[] res = new int[queries.length];
        i = 0;
        for(int query : queries){
            res[i++] = map.get(query);
        }
        return res;
        
    }
}
