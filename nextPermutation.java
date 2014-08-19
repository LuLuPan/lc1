public class Solution {
    public void nextPermutation(int[] num) {
        if (num.length <= 1) return;
        int n = num.length;

        int last = -1;
        for (int i = n - 1; i >= 1; i--) {
            if (num[i - 1] < num[i]) {
                // from right to left, find the first one voliates ascending
                last = i - 1;
                break;
            }
        }

        int partition = 0;
        // if no voilation, no need to swap
        if (last >= 0) {
            for (int i = n - 1; i > last; i--) {
                if (num[i] > num[last]) {
                    partition = i;
                    break;
                }
            }
    
            // swap
            int tmp = num[last];
            num[last] = num[partition];
            num[partition] = tmp;
        }
        
        // reverse the array from violated point
        for (int i = last + 1; i < (n - last) / 2 + 1 + last; i++) {
            int tmp = num[i];
            num[i] = num[n - i + last];
            num[n - i + last] = tmp;
        }
    }
}