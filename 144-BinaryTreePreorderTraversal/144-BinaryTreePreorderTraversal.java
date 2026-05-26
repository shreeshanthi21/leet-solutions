// Last updated: 5/26/2026, 12:32:38 PM
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
    private void func(TreeNode node, List<Integer> ans){
        if(node==null) return;
        ans.add(node.val);
        func(node.left,ans);
        func(node.right,ans);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        func(root,ans);
        return ans;
    }
}