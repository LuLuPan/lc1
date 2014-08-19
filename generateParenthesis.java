public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        if (n <= 0) return result;
        dfs(n, "", 0, 0, result);
        return result;
    }

    private void dfs(int n, String s, int l, int r, List<String> result) {
        if (l == n) {
            char[] right = new char[n - r];
            Arrays.fill(right, ')');
            String new_str = new String(s);
            new_str += new String(right);
            result.add(new_str);
            return;
        }

        dfs(n, s + "(", l + 1, r, result);
        if (l > r) dfs(n, s + ")", l, r + 1, result);
    }
}