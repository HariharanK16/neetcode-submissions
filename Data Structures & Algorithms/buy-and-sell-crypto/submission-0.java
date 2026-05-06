class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int n = prices.length;
        int bp = prices[0];
        for(int j = 1; j<n;j++){
            if(bp>=prices[j]){
                bp = prices[j];
            }
            else{
                int diff = prices[j]-bp;
                profit = Math.max(diff, profit);

            }
            
        }
        return profit;

    }
}
