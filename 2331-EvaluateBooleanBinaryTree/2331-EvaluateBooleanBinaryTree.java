// Last updated: 5/30/2026, 8:08:21 PM
1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    public boolean evaluateTree(TreeNode root) {
18        if(root.left==null && root.right==null) {
19            return root.val==1;
20        }
21        boolean left=evaluateTree(root.left);
22        boolean right=evaluateTree(root.right);
23        if(root.val==2) return left || right;
24        return left && right;
25    }   
26}