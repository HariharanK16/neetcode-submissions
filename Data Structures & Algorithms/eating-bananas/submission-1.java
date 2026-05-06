class Solution {
    private int minRateFinder(int[] piles, int l, int r, int h, int res){
        if(l>r){
            return res;
        }
        int k = l+(r-l)/2;
        int tt = 0;
        for(int i:piles){
            tt+=Math.ceil((double)i/k);
        }
        if(tt<=h){
            res = k;
            r = k-1;
        } else {
            l = k+1;
        }
        return minRateFinder(piles,l,r,h,res);
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<n;i++){
            max = Math.max(max, piles[i]);
        }
        return minRateFinder(piles,1,max,h,max);
    }
}
