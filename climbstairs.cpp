class Solution {
public:
    int climbStairs(int n) {
        if (n <= 0) return 0;
        int fn = 0, fn_1 = 2, fn_2 = 1;
        if (n == 1) return fn_2;
        if (n == 2) return fn_1;

        for (int i = 3; i <= n; i++) {
        	fn = fn_1 + fn_2;
        	fn_2 = fn_1;
        	fn_1 = fn;
        }

        return fn;
    }
};