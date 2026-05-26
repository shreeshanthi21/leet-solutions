// Last updated: 5/26/2026, 12:32:53 PM
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
    int sum=0;
    public void sum(TreeNode node,int tsum){
        if(node==null) return;
        tsum=tsum*10+node.val;
        if(node.left==null && node.right==null) sum+=tsum;
        if(node.left!=null){
            sum(node.left,tsum);
        }
        if(node.right!=null){
            sum(node.right,tsum);
        }
    }
    public int sumNumbers(TreeNode root) {
        int tsum=0;
        sum(root,tsum);
        return sum;
    }
}