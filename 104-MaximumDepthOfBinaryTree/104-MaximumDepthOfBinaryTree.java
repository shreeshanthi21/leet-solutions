// Last updated: 5/26/2026, 12:33:16 PM
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
    public int Height(TreeNode node){
        if(node==null) return 0;
        int lh=Height(node.left);
        int rh=Height(node.right);
        return 1+Math.max(lh,rh);
    }
    public int maxDepth(TreeNode root) {
        return Height(root);
    }
}