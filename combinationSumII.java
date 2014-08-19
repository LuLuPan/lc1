public class Solution {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (num.length == 0) return result;

        Arrays.sort(num);
        if (target < num[0]) return result;

        List<Integer> path = new ArrayList<Integer>();
        dfs(num, target, 0, path, result);
        return result;
    }

    private void dfs(int[] num, int gap, int start, List<Integer> path, List<List<Integer>> result) {
        if (gap == 0) {
            List<Integer> tmp = new ArrayList<Integer>(path);
            result.add(tmp);
        }
        int previous = -1;
        for (int i = start; i < num.length; i++) {
            if (gap < num[i]) return;
            if (previous == num[i]) continue;
            previous = num[i];
            path.add(num[i]);
            dfs(num, gap - num[i], i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }
}