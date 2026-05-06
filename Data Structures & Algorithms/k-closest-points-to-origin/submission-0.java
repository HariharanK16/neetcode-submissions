class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] res= new int[k][2];

        int n = points.length;

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->{
            int val1 = (a[0]*a[0]) + (a[1]*a[1]);
            int val2 = (b[0]*b[0]) + (b[1]*b[1]);

            return val2 - val1;
        });

        for(int[] point: points){
            pq.offer(point);
            if(pq.size()>k){
                pq.poll();
            }
        }


        while(!pq.isEmpty()){
            res[k-pq.size()]=pq.poll();
        }

        return res;
    }
}
