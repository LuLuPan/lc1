public class Solution {
    public boolean isPalindrome(int x) {
        if ( x < 0) return false;
        int d = 1;

        // should be >= 10, since 1, 2, ..., 9
        while (x / d >= 10) {
            d *= 10;
        }

        while (x > 0) {
            int q = x / d;
            int r = x % 10;

            if (q != r) return false;

            x = x % d;
            x /= 10;
            d /= 100;
        }

        return true;
    }
}