public class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') return 0;

        int cur = 1;
        int prev = 0;
        for (int i = 1; i <= s.length(); i++) {
            if (s.charAt(i) == '0') cur = 0;

            if (i < 2 || !(s.charAt(i - 2) == '1' || 
                (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')))
                prev = 0;

            int temp = cur;
            cur += prev;
            prev = temp;
        }

        return cur;
    }
}