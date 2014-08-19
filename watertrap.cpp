class Solution {
public:
    int trap(int A[], int n) {
        if (n <= 2) return 0;
        int max = 0;
        int water = 0;
        for (int i = 0; i < n; i++)
        	if (A[i] > A[max])
        	    max = i;
        for (int i = 0, peak = 0; i < max; i++) {
        	if (A[i] > peak) peak = A[i];
        	else water += peak - A[i];
        }

        for (int i = n - 1, peak = 0; i > max; i--) {
            if (A[i] > peak) peak = A[i];
        	    else water += peak - A[i];	
        }

        return water;
    }
};