public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        if (s.length() > 12) return result;

        String path = new String();
        dfs(s, path, 0, 0, result);
        return result;
    }

    private void dfs(String s, String path, int start, int steps, List<String> result) {
        if (start == s.length() && steps == 4) {
            String temp = new String(path);
            temp = temp.substring(0, temp.length() - 1);
            result.add(temp);
            return;
        }

        if ((s.length() - start) > (4 - steps) * 3) return;
        if ((s.length() - start) < (4 - steps)) return;

        for (int i = start; i < Math.min(start + 3, s.length()); i++) {
            String digits = new String(s.substring(start, i + 1));
            int num = Integer.parseInt(digits);
            if (num <= 255) {
                path += digits;
                dfs(s, path + ".", i + 1, steps + 1, result);
                String num_str = Integer.toString(num);
                path = path.substring(0, path.length() - num_str.length());
            }
            // 0 cannot be prefix, only could be a single numbe of postfix
            if (num == 0) break;
        }
    }
}