class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int r = 1, l = 0;

        while(r<prices.length){
            if(prices[l]<prices[r]){
                profit = Math.max(prices[r]-prices[l], profit);      
            }else{
                l = r;
            }
            r++;
        }
        return profit;
    }
}
