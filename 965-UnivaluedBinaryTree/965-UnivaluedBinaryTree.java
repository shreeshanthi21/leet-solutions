// Last updated: 5/30/2026, 7:58:18 PM
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
17    boolean found=false;
18    public void dfs(TreeNode root,int value){
19        if(root==null) return;
20        if( root.val!=value)
21            {found=true;
22            return;} 
23        dfs(root.left,value);
24        dfs(root.right,value);
25        
26    }
27    public boolean isUnivalTree(TreeNode root) {
28        if(root==null) return true;
29        int value=root.val;
30        dfs(root,value);
31        if(found) return false;
32        return true;
33    }
34}