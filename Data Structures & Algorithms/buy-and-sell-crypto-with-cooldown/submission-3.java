class Solution {
    Map<Pair<Integer,Boolean>,Integer> memo = new HashMap<>();
    public int maxProfit(int[] prices) {

        return dfs(prices,true,0);
    }
    private int dfs(int prices[],boolean buy, int i){
        Pair<Integer,Boolean> key = new Pair(i,buy);
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        if(i>=prices.length){
            return 0;
        }
        if(buy){
            int buyer = dfs(prices, false, i+1) - prices[i];
            int cool = dfs(prices, true, i+1);
            memo.put(key, Math.max(buyer,cool));
        }else{
            int sell = dfs(prices, true, i+2) + prices[i];
            int cool = dfs(prices, false,i+1 );
            memo.put(key, Math.max(sell,cool));
        }
        return memo.get(key);
    }
}
