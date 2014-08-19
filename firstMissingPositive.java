public class Solution {
    public int firstMissingPositive(int[] A) {
        int n = A.length;
        // based on bucket sort
        for (int i = 0; i < n; i++) {
            while (A[i] != i + 1) {
                if (A[i] <= 0 || A[i] >= n || A[i] == A[A[i] - 1])
                    break;
                int temp = A[i];
                A[i] = A[temp - 1];
                A[temp - 1] = temp;
            }
        }
       
        // first positive numbe be missed
        for (int i = 0; i < n; i++)
            if (A[i] != i + 1)
                return i + 1;

        return A.length + 1;
    }
}