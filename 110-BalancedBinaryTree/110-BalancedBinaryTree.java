// Last updated: 5/28/2026, 12:35:43 AM
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
17    public int minDepth(TreeNode root) {
18        if(root==null) return 0;
19        int leftdepth=minDepth(root.left);
20        int rightdepth=minDepth(root.right);
21        if(root.left==null && root.right==null) return 1;
22        if(root.left==null) return 1+rightdepth;
23        if(root.right==null) return 1+leftdepth;
24        return Math.min(leftdepth,rightdepth)+1;
25    }
26}