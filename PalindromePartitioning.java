public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        int n = s.length();
        if (n == 0) return result;

        // dp[i][j]: s[i..j] is a palindrome partition
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--)
            for (int j = i; j < n; j++)
                if ((s.charAt(i) == s.charAt(j)) && ((j - i < 2) || dp[i + 1][j - 1]))
                    dp[i][j] = true;

        List<String> path = new ArrayList<String>();
        gen_path(s, dp, s.length() - 1, path, result);
        return result;

    }

    private void gen_path(String s, boolean[][] dp, int cur, List<String> path,
        List<List<String>> result) {
        if (cur == -1) {
            List<String> tmp = new ArrayList<String>(path);
            Collections.reverse(tmp);
            result.add(tmp);
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if (dp[i][cur]) {
                path.add(s.substring(i, cur + 1));
                gen_path(s, dp, i - 1, path, result);
                path.remove(path.size() - 1);
            }
        }
    }
}