// Last updated: 5/26/2026, 12:31:09 PM
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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList();
        if(root==null) return true;
        queue.add(root);
        boolean even=true;
        while(!queue.isEmpty()){
            int levelSize=queue.size();
            int prevVal=even?Integer.MIN_VALUE:Integer.MAX_VALUE;
            while(levelSize-- >0){
                root=queue.poll();
                if(even && (root.val%2==0 || root.val<=prevVal)) return false;
                if(!even && (root.val%2==1 || root.val>=prevVal)) return false;
                prevVal=root.val;
                if(root.left!=null) queue.add(root.left);
                if(root.right!=null) queue.add(root.right);
            }
            even=!even;
        }
        return true;
    }
}