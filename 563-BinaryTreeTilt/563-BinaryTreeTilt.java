// Last updated: 5/30/2026, 7:49:01 PM
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
17    int totalTilt = 0;
18
19    public int findTilt(TreeNode root) {
20        totalTilt = 0;
21        valueSum(root);
22        return totalTilt;
23    }
24
25    private int valueSum(TreeNode node) {
26        if (node == null) {
27            return 0;
28        }
29        int leftSum = valueSum(node.left);
30        int rightSum = valueSum(node.right);
31        int tilt = Math.abs(leftSum - rightSum);
32        totalTilt += tilt;
33        return node.val + leftSum + rightSum;
34    }
35}