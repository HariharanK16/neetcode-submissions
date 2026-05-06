class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int r = 0,l = 0;
        for(int pile : piles){
            r = Math.max(r,pile);
        }
        int res = r;

        while(l<=r){
            int k = l + (r - l)/2;
            long totalTime = 0;
            for(int pile : piles){
                totalTime += Math.ceil((double) pile / k);
            }
            if(totalTime <= h){
                r = k - 1;
                res = k;
            }
            else{
                l = k + 1;
            }
        }
        return res;

    }
}
