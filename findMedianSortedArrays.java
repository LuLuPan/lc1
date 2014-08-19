public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length;
        int n = B.length;
        int total = m + n;
        double median = 0;
        if (total % 2 == 1) {
            // odd
            median = find_kth(A, m, B, n, total / 2 + 1);
        }
        else
        {
            // even
            median = (find_kth(A, m, B, n, total / 2) + 
                find_kth(A, m, B, n, total / 2 + 1)) / 2.0;
        }

        return median;
    }

    private int find_kth(int A[], int m, int[] B, int n, int k) {
        // always treat as m < n
        if (m > n) return find_kth(B, n, A, m, k);
        if (m == 0) return B[k - 1];
        if (k == 1) return Math.min(A[0], B[0]);
        // compare A[k/2 - 1] and B[k/2 - 1]
        // if A[k/2 - 1] < B[k/2 - 1], kth cannot be within A[0...k/2]
        // if A[k/2 - 1] > B[k/2 - 1], kth cannot be within B[0...k/2]
        // if A[k/2 - 1] = B[k/2 - 1], kth should be A[k/2 - 1] or B[k/2 - 1]
        int ia = Math.min(k / 2, m);
        int ib = k - ia;
        if (A[ia - 1] < B[ib - 1])
            return find_kth(Arrays.copyOfRange(A, ia, m), m - ia, B, n, k - ia);
        else if (A[ia - 1] > B[ib - 1])
            return find_kth(A, m, Arrays.copyOfRange(B, ib, n), n - ib, k - ib);
        else
            return A[ia - 1];
    }
}