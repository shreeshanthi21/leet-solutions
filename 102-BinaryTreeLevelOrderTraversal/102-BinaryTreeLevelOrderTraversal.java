// Last updated: 5/26/2026, 12:33:19 PM
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        List<List<Integer>> ans=new LinkedList<List<Integer>>();
        if(root==null) return ans;
        queue.offer(root);//if queue empty, add, else return false
        while(!queue.isEmpty()){
            List<Integer> sublist=new ArrayList<Integer>();
            int listsize=queue.size();
            for(int i=0;i<listsize;i++){
                if(queue.peek().left!=null) queue.offer(queue.peek().left);
                if(queue.peek().right!=null) queue.offer(queue.peek().right);
                sublist.add(queue.poll().val);
            }
            ans.add(sublist);
        }
        return ans;
    }
}