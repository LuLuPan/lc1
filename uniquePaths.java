public class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;

        int[][] dp = new int[2][n];


        for (int i = 0; i < 2; i++)
            dp[i][0] = 1;

        for (int j = 1; j < n; j++)
            dp[0][j] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++)
                dp[i % 2][j] = dp[(i - 1) % 2][j] + dp[i % 2][j - 1];
        }

        return dp[(m - 1) % 2][n - 1];
    }
}