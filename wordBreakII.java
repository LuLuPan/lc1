public class Solution {
    public List<String> wordBreak(String s, Set<String> dict) {
        List<String> result = new ArrayList<String>();
        if (s.length() == 0 || dict.size() == 0) return  result;

        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;
        // dp[i][j] means work breakable at range [j, i)
        boolean[][] dp = new boolean[s.length() + 1][s.length()];

        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (f[j] && dict.contains(s.substring(j, i))) {
                    f[i] = true;
                    dp[i][j] = true;
                }
            }
        }

        List<String> path = new ArrayList<String>();
        gen_path(s, dp, s.length(), path, result);
        return result;
    }

    private void gen_path(String s, boolean[][] dp, int cur,
        List<String> path, List<String> result) {
        if (cur == 0) {
            String tmp = new String();
            ListIterator li = path.listIterator(path.size());
            while(li.hasPrevious()) {
                temp += li.previous() + " ";
            }
            tmp = tmp.substring(0, length() - 1);
            result.add(tmp);
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if (dp[cur][i] == true) {
                path.add(s.substring(i, cur));
                //start from the last substr, move to front
                gen_path(s, dp, i, path, result);
                path.remove(path.size() - 1);
            }
        }
    }
}