// Last updated: 5/26/2026, 12:33:13 PM
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
    int postorderIndex; 
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        postorderIndex = postorder.length - 1; 
        return buildTree(postorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] postorder, int left, int right) {
        // Base case: if boundaries cross, there are no elements left to process
        if (left > right) return null;
        int rootVal = postorder[postorderIndex--];
        TreeNode node = new TreeNode(rootVal);
        int inorderRootIndex = map.get(rootVal);
        node.right = buildTree(postorder, inorderRootIndex + 1, right);
        node.left = buildTree(postorder, left, inorderRootIndex - 1);
        return node;
    }
}