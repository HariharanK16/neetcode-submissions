class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);

        Map<Integer,Integer> result = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);

        int n = intervals.length;
        int i = 0;
        for(int query:Arrays.stream(queries).sorted().toArray()){
            while(i<n && intervals[i][0]<=query){
                int l = intervals[i][0];
                int r = intervals[i][1];
                pq.offer(new int[]{r-l+1,r});
                i++;
            }
            while(!pq.isEmpty() && pq.peek()[1]<query){
                pq.poll();
            }
            result.put(query, pq.isEmpty() ? -1 : pq.peek()[0]);
        }
        int res[] = new int[queries.length];
        i = 0;
        for(int query:queries){
            res[i++] = result.get(query);
        }
        return res;
    }
}
