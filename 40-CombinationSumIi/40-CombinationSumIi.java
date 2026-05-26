// Last updated: 5/26/2026, 12:34:10 PM
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(0, new ArrayList<>(), 0, target, res, candidates); // pass candidates here
        return res;
    }

    private void dfs(int i, List<Integer> curr, int total, int target, List<List<Integer>> res, int[] candidates) {
        if (total == target) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if (i >= candidates.length || total > target) return;
        for (int j = i; j < candidates.length; j++) {
            // Skip duplicates at the same recursive level
            if (j > i && candidates[j] == candidates[j - 1]) continue;

            if (total + candidates[j] > target) break; // pruning

            curr.add(candidates[j]);
            dfs(j + 1, curr, total + candidates[j], target, res, candidates); // move to next index
            curr.remove(curr.size() - 1); // backtrack
        }
    }
}