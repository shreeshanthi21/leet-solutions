// Last updated: 5/26/2026, 12:31:29 PM
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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        List<Double> result=new LinkedList<Double>();
        if(root==null) return result;
        queue.offer(root);
        while(!queue.isEmpty()){
            int listsize=queue.size();double sum=0.00;
            for(int i=0;i<listsize;i++){
                TreeNode curr=queue.poll();//if not a variable, it'll throw null point error cause for adding to sum, we gotta poll and it wont be able to peek() for queue.peek().left and right
                sum+=(double)curr.val;
                if(curr.left!=null) queue.offer(curr.left);
                if(curr.right!=null) queue.offer(curr.right);
            }
            result.add((double)sum/listsize);
        }
        return result;
    }
}