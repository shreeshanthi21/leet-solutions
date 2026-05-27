// Last updated: 5/28/2026, 12:50:06 AM
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
17    public void dfs(TreeNode root,String path,List<String> paths){
18        if(root.left==null && root.right==null) paths.add(path+root.val);
19        if(root.left!=null) dfs(root.left,path+root.val+"->",paths);
20        if(root.right!=null) dfs(root.right,path+root.val+"->",paths);
21    }
22    public List<String> binaryTreePaths(TreeNode root) {
23        List<String> result=new ArrayList<>();
24        if(root!=null) dfs(root,"",result);
25        return result;
26    }
27}