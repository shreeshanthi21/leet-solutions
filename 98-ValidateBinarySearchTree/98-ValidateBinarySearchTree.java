// Last updated: 5/26/2026, 12:33:24 PM
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
    public boolean helper(TreeNode root,Long mini,Long maxi){
        if(root==null) return true;
        if(root.left!=null && root.left.val>=root.val) return false;
        if(root.right!=null && root.right.val<=root.val ) return false;
        if(root.val<=mini || root.val>=maxi) return false;
        return helper(root.left,mini,(long)root.val) && helper(root.right,(long)root.val,maxi);
    }
    public boolean isValidBST(TreeNode root) {
        return helper(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
}