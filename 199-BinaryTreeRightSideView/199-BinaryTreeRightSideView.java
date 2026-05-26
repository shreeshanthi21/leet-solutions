// Last updated: 5/26/2026, 12:32:20 PM
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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        List<Integer> ans=new LinkedList<Integer>();
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
            ans.add(sublist.get(listsize-1));
        }
        return ans;
    }
}