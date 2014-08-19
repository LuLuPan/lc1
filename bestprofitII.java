public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        
        int profit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            int delta = prices[i] - prices[i - 1]; 
            profit += (delta > 0 ? delta : 0);
        }
        
        if (profit < 0) profit = 0;
        return profit;
    }
}