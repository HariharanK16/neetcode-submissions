class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        // Arrays.sort(queries);
        Map<Integer,Integer> res = new HashMap<>();
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int n = queries.length;
        int i = 0,m=intervals.length;
        for(int query:Arrays.stream(queries).sorted().toArray()){
            while(i<m && intervals[i][0] <= query){
                int l = intervals[i][0];
                int r = intervals[i][1];
                q.offer(new int[]{r-l+1, r});
                i++;
            }
            while(!q.isEmpty() && q.peek()[1]<query){
                q.poll();
            }

            res.put(query, q.isEmpty() ? -1 : q.peek()[0]);
        }
        int[] result = new int[queries.length];
        i = 0;
        for(int query:queries){
            result[i++] = res.get(query);
        }
        return result;
    }
}
