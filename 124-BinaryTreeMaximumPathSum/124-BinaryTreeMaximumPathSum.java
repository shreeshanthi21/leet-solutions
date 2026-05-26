// Last updated: 5/26/2026, 12:32:59 PM
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
    int maxDiameter=Integer.MIN_VALUE;
    public int height(TreeNode root){
        if(root==null) return 0;
        int leftgain=Math.max(0,height(root.left));
        int rightgain=Math.max(0,height(root.right));
        int currPathSum=root.val+leftgain+rightgain;
        maxDiameter=Math.max(maxDiameter,currPathSum);
        return root.val+Math.max(leftgain,rightgain);
    }
    public int maxPathSum(TreeNode root) {
        height(root);
        return maxDiameter;
    }
}