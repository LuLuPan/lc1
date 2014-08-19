public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null && p == null) return false;
        if (p.length() == 0 || s.length() == 0) return false;
        boolean matched = true;
        char prev = s.charAt(0);
        int i = 0, j = 0;
        for (; i < s.length() && j < p.length();) {
            if (s.charAt(i) != p.charAt(j)) {
                if ((j + 1) < p.length() && p.charAt(j) != '.' && 
                    p.charAt(j) != '*' && p.charAt(j + 1) == '*') {
                    j += 2;
                    continue;
                } else if (p.charAt(j) == '.') {
                    prev = '.';
                    i++;
                    j++;
                } else if (p.charAt(j) == '*') {
                    if (s.charAt(i) == prev || prev == '.')
                        i++;
                    else
                        j++;
                } else {
                    matched = false;
                    break;
                }
            } else {
                prev = s.charAt(i);
                i++;
                j++;
            }
        }
        if (i < s.length())
            matched = false;
        else if (i == s.length() && j < p.length()) {
            if (p.charAt(j) != '*')
                matched = false;
            else if(j < (p.length() - 1) && (p.charAt(j + 1) != '*' && p.charAt(j + 1) != prev))
                matched = false;
        }
        return matched;
    }
}

public class Solution {
    public boolean isMatch(String s, String p) {
        if (p.length() == 0)
            return s.length() == 0;
        // in case p will forward 2 steps
        if (p.length() == 1) {
            return (s.length() == 1 && (s.charAt(0) == p.charAt(0) || 
                p.charAt(0) == '.'));
        }

        // if next is not *, should be matched at [0]
        if (p.charAt(1) != '*') {
            if (s.length() < 1) return false;
            return (s.charAt(0) == p.charAt(0) || 
                p.charAt(0) == '.') && isMatch(s.substring(1), p.substring(1)); 
        } else {
            // next is *
            // Eg. s: aaa p: ab*a*c*a
            while (s.length() > 0 && (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0))) {
                if (isMatch(s, p.substring(2)))
                    return true;
                s = s.substring(1);
            }
        }

        return isMatch(s, p.substring(2));
    }
}