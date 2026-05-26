// Last updated: 5/26/2026, 12:33:22 PM
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private void dfs(TreeNode node,List<Integer> ans){
        if(node==null){ans.add(Integer.MIN_VALUE);return;}
        ans.add(node.val);
        dfs(node.left,ans);
        dfs(node.right,ans);
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> ans1=new ArrayList<>();
        List<Integer> ans2=new ArrayList<>();
        dfs(p,ans1);
        dfs(q,ans2);
        if(ans1.equals(ans2)) return true;
        return false;
    }
}