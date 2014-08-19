public class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n == 0) return 0;
        int[] increment = new int[n];
        for (int i = 1, inc = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1])
                increment[i] = Math.max(inc++, increment[i]);
            else
                inc = 1;
        }

        // if one rate violates ascending order, it will add 2 candy
        for (int i = n - 2, inc = 1; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1])
                increment[i] = Math.max(inc++, increment[i]);
            else
                inc = 1;
        }

        int sum = 0;
        for (int num : increment)
            sum += num;
        return sum + n;
    }
}