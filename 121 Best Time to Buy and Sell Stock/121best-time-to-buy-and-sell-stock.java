class Solution {
    public int maxProfit(int[] prices) {
        // for a strictly decreasing array the profit = 0
        // buy on the day which has minimum price , sell on the day which has maximum price. ensure that selling day is after the buying day
        int minPrices = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i = 0;i < prices.length; i++){
            if(prices[i] < minPrices){
                minPrices = prices[i];
            }
            maxProfit = Math.max(maxProfit, prices[i] - minPrices);
        }
        return maxProfit;
    }
}