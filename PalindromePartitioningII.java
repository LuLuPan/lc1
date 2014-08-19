public class Solution {
    public int minCut(String s) {
        int n = s.length();
        if (n == 0) return 0;
        // f[i] the min cut from i to n-1
        // each new palindrom partition be found will increase a DP
        // f[i] = min(f[i], f[j + 1] + 1)
        int[] f = new int[n + 1];
        // max cut in each sub region
        for (int i = 0; i <= n; i++)
            f[i] = n - 1 - i;
        // s[i, j] is a palindrome or not
        boolean[][] p = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if ((s.charAt(i) == s.charAt(j)) && ((j - i < 2) || p[i + 1][j - 1])) {
                    p[i][j] = true;
                    f[i] = Math.min(f[i], f[j + 1] + 1);
                }
            }
        }
        return f[0];
    }
}