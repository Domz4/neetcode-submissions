class Solution {
    public int maxProfit(int[] prices) {
        int lowest=prices[0], maxProfit=0;
        for(int i=1; i<prices.length; i++) {
            int profit = prices[i] - lowest;

            if(maxProfit < profit) {
                maxProfit = profit;
            }

            if(lowest > prices[i]){
                lowest = prices[i];
            }
        }
        return maxProfit;
    }
}
