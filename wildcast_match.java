public class Solution {
    public boolean isMatch(String s, String p) {
        int star = -1;
        int mark = -1;
        int i = 0, j = 0;
        while (i < s.length()) {
            if (j < p.length() && (s.charAt(i) == p.charAt(j) || 
                p.charAt(j) == '?')) {
                // match single
                i++;
                j++;
            } else if (j < p.length() && p.charAt(j) == '*') {
                // * will be used to match afterward
                star = j++;
                mark = i;
            } else if (star != -1) {
                // no match, use previous * try to match
                i = ++mark;
                j = star + 1;
            } else {
                return false;
            }
        }

        while (j < p.length() && p.charAt(j) == '*')
            j++;
        return j == p.length();
    }
}