public class Solution {
    public int reverse(int x) {
        int r = 0;
        do {
            r = r * 10 + x % 10;
            x /= 10;
        } while(x != 0);

        return r;
    }
}