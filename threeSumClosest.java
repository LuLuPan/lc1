public class Solution {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int gap = Integer.MAX_VALUE;

        int result = 0;
        for (int i = 0; i < num.length; i++) {
            int k =  num.length - 1;
            int j = i + 1;
            while (j < k) {
                int sum = num[i] + num[j] + num[k];
                int temp_gap = Math.abs(sum - target);
                if (temp_gap < gap) {
                    result = sum;
                    gap = temp_gap;
                    //Error: Different from 3sum, change j, k when found
                    // need to try all combination in this case
                    //j++;
                    //k--;
                }
                else if (sum > target)
                    k--;
                else
                    j++;
            }
        }

        return result;
    }
}