public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (target == 0 || candidates.length == 0) return result;
        Arrays.sort(candidates);
        if (target < candidates[0]) return result;

        List<Integer> path = new ArrayList<Integer>();
        dfs(candidates, 0, target, path, result);
        return result;
    }

    private void dfs(int[] candidates, int start, int gap, List<Integer> path, 
        List<List<Integer>> result) {
        if (gap == 0) {
            List<Integer> tmp = new ArrayList<Integer>(path);
            result.add(tmp);
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (gap < candidates[i])
                return;
            path.add(candidates[i]);
            dfs(candidates, i, gap - candidates[i], path, result);
            path.remove(path.size() - 1);
        }
    }
}