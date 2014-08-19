public class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        if (s1.length() == 0) return false;
        int N = s1.length();

        // dp[n][i][j]: length is n[0...N], s1 starts from i, s2 starts from j,
        // s1 and s2 are scamble string or not
        // dp[n][i][j] = (dp[k][i][j] && dp[n-k][i+k][j+k]) ||
        //               (dp[k][i][j+n-k] && dp[n-k][i+k][j])
        // target: dp[N][0][0]
        boolean [][][] dp = new boolean[N + 1][N][N];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                dp[1][i][j] = (s1.charAt(i) == s2.charAt(j));

        for (int n = 1; n <= N; n++)
            for (int i = 0; i + n <= N; i++)
                for (int j = 0; j + n <= N; j++)
                    for (int k = 1; k < n; k++) {
                        dp[n][i][j] = (dp[k][i][j] && dp[n - k][i + k][j + k] ||
                            dp[k][i][j + n - k] && dp[n - k][i + k][j]);
                        if (dp[n][i][j])
                            break;
                    }

        return f[N][0][0];
    }
}