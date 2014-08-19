class Solution {
public:
    int maxSubArray(int A[], int n) {
        int maxsum = INT_MIN;
        int d = INT_MIN;
        for (int i = 0; i < n; i++) {
            d = max(d + A[i], A[i]);
            maxsum = max(maxsum, d);
        }

        return maxsum;
    }
};