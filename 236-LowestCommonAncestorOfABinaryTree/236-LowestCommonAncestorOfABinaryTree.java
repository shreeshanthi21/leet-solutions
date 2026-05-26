// Last updated: 5/26/2026, 12:31:59 PM
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p || root==q) return root;
        TreeNode left1=lowestCommonAncestor(root.left,p,q);
        TreeNode right1=lowestCommonAncestor(root.right,p,q);
        // Case 1: p and q are split across left and right subtrees
        if (left1 != null && right1 != null) {
            return root; 
        }
        // Case 2: Both p and q are down the left subtree
        if (left1 != null) {
            return left1; 
        }
        // Case 3: Both p and q are down the right subtree
        if (right1 != null) {
            return right1; 
        }
        return null;
    }
}