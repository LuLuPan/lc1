public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (num.length < 3) return result;

        HashSet<List<Integer>> set = new HashSet<List<Integer>>();
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            int target = -num[i];
            int k = num.length - 1;
            int j = i + 1;
            while(j < k) {
                if (num[k] + num[j] == target) {
                    List<Integer> sol = new ArrayList<Integer>();
                    sol.add(num[i]);
                    sol.add(num[j]);
                    sol.add(num[k]);
                    if (set.add(sol))
                        result.add(sol);
                    k--;
                    j++;
                }
                else if (num[k] + num[j] < target)
                    j++;
                else
                    k--;
            }
        }

        Arrays.sort(num);
        return result;
    }
}