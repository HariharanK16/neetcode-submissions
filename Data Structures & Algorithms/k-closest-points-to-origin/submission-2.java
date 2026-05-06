class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            int val1 = (a[0]* a[0]) + (a[1]*a[1]);
            int val2 = (b[0]* b[0]) + (b[1]*b[1]);
            return val2 - val1;
        });

        int[][] res = new int[k][2];

        for(int[] point:points){
            pq.offer(point);
            if(pq.size()>k){
                pq.poll();
            }
        }

        int i = 0;
        for(int[] point:pq){
            res[i++] = point;
        }
        return res;

    }
}
