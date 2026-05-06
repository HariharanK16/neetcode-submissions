class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));
        List<int[]> res = new ArrayList<>();

        int n = intervals.length;
        if(n == 0){
            return new int[0][];
        }

        res.add(intervals[0]);
        int ind = 0;
        for(int[] interval:intervals){
            int[] lastAdded = res.get(res.size()-1);
            if(lastAdded[1]>=interval[0]){
                lastAdded[0] = Math.min(interval[0],lastAdded[0]);
                lastAdded[1] = Math.max(interval[1],lastAdded[1]);
            } else {
                res.add(interval);
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
