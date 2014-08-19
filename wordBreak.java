public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        if (s.length() == 0 || dict.size() == 0)
            return false;

        boolean[] f = new boolean[s.length() + 1];
        // f[i] means s[0...i) could break or not
        // f[i] = anyof (f[j] && s[j..i) within dict)
        // 0 stands for empty
        f[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (f[j] && dict.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }

        return f[s.length()];
    }
}