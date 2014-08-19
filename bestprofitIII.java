public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int n = prices.length;
        // f[i] -> maxprofit in [0...i]
        int[] f = new int[n];

        int minprice = prices[0];
        for (int i = 1; i < n; i++) {
            minprice = Math.min(minprice, prices[i]);
            f[i] = Math.max(f[i - 1], (prices[i] - minprice));
        }

        int maxprice = prices[n - 1];
        int res = 0;
        for (int i = n - 2; i >= 0; i--) {
            maxprice = Math.max(maxprice, prices[i]);
            int profit = maxprice - prices[i];
            res = Math.max(res, Math.max(profit + f[i], f[i]));
        }
        
        return res;
    }
}