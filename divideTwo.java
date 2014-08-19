public class Solution {
    public int divide(int dividend, int divisor) {
        int sign = (dividend > 0 ? 1 : - 1) * (divisor > 0 ? 1 : -1);
        // long in case of INT_MIN
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        int count = 0;
        while (a >= b) {
            int multi = 1;
            long bb = b;
            while (a >= bb) {
                a -= bb;
                count += multi;
                // double divisor to accelerate
                // and avoid overflow
                if (bb < Integer.MAX_VALUE >> 1) {
                    bb += bb;
                    multi += multi;
                }
            }
        }

        return sign * count;
    }
}