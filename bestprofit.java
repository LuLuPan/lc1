public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;

        int res = prices[1] - prices[0];
        int minprice = prices[0];

        for (int i = 2; i < prices.length; i++) {
            minprice = Math.min(minprice, prices[i - 1]);
            res = Math.max(res, prices[i] - minprice);
        }

        if (res < 0) res = 0;
        return res;
    }
}