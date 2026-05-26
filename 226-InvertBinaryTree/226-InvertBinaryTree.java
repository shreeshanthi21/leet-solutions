// Last updated: 5/26/2026, 12:32:04 PM
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
    private TreeNode preorder(TreeNode node){
        if(node==null) return node;
        TreeNode temp=node.left;
        node.left=node.right;
        node.right=temp;
        preorder(node.right);
        preorder(node.left);
        return node;
    }
    public TreeNode invertTree(TreeNode root) {
        return preorder(root);
    }
}