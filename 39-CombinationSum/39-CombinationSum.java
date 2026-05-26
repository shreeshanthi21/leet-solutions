// Last updated: 5/26/2026, 12:34:11 PM
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, new ArrayList<>(), 0, target, res, candidates); // pass candidates here
        return res;
    }

    private void dfs(int i, List<Integer> curr, int total, int target, List<List<Integer>> res, int[] candidates) {
        if (total == target) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if (i >= candidates.length || total > target) return;
        curr.add(candidates[i]);
        dfs(i, curr, total + candidates[i], target, res, candidates);
        curr.remove(curr.size() - 1);
        dfs(i + 1, curr, total, target, res, candidates);
    }
}
