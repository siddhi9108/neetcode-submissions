class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int buy = 0;buy<prices.length;buy++){
            for(int sell = buy+1;sell<prices.length;sell++){
                int prof = prices[sell] - prices[buy];
                profit = Math.max(profit, prof);
            }
        }
        return profit;
    }
}
