// Last updated: 5/26/2026, 12:33:14 PM
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
    int preorderIndex = 0;
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return buildTree(map, preorder, 0, preorder.length-1);
    }

    private TreeNode buildTree(Map<Integer,Integer> map, int[] preorder, int left, int right){
        if(left>right) return null;
        int item = preorder[preorderIndex++];
        TreeNode node = new TreeNode(item);
        node.left = buildTree(map, preorder, left, map.get(item)-1);
        node.right = buildTree(map, preorder, map.get(item)+1, right);
        return node;
    }
}