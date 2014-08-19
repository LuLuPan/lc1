public class Solution {
    public int jump(int[] A) {
        // max distance has been reached
        int last = 0;
        // max distance could be reached at cur pos
        int cur = 0;
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            if (last < i) {
                // need to move one step
                last = cur;
                result++;
            }

            cur = Math.max(cur, A[i] + i);
        }

        return result;
    }
}