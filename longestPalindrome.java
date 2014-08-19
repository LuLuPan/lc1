public class Solution {
    // DP
    // f[i, j]: 1) true if i == j
    //          2) true if s[i] == s[j], j - i < 2
    //          3) true if s[i] == s[j] && f(i+1, j-1), j - i >= 2
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0 || n == 1) return s;
        String result = new String();

        boolean[][] dp = new boolean[n][n];
        dp[0][0] = true;

        int max_len = 0;
        int left = 0;
        int right = 0;

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            for (int j = 0; j < i; j++) {
                if (i == j || (s.charAt(i) == s.charAt(j) && i == j + 1) ||
                    (s.charAt(i) == s.charAt(j) && dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    if (i - j + 1 > max_len) {
                        max_len = i - j + 1;
                        left = j;
                        right = i;
                    }
                }
            }
        }

        return s.substring(left, right + 1);
    }
}