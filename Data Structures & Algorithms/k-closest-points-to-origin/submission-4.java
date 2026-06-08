class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            int val1 = a[0]*a[0] + a[1]*a[1];
            int val2 = b[0]*b[0] + b[1]*b[1];
            return val2 - val1;
        });

        for(int[] point:points) {
            pq.add(point);
            if(pq.size()>k) pq.poll();
        }

        int[][] resPoints = new int[k][2];

        while(k>0){
            resPoints[k-1] = pq.poll();
            k--;
        }
        return resPoints;

    }
}
