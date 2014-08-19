public class Solution {
    public int singleNumber(int[] A) {

        int n = A.length;
        int M = Integer.SIZE;
        int[] count = new int[M];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < M; j++) {
                count[j] += (A[i] >> j) & 1;
                count[j] %= 3;
            }
        }

        int result = 0;
        // recover the single number
        for (int i = 0; i < M; i++)
            result += (count[i] << i);

        return result;
    }
}