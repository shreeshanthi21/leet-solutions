// Last updated: 6/3/2026, 7:07:46 PM
1class Solution {
2    public int minPathSum(int[][] grid) {
3       
4        int m = grid.length-1;
5        int n = grid[0].length-1;
6        int[][]dp = new int[m+2][n+2];
7        dp[0][0] = grid[0][0];
8        for(int i=0;i<=m;i++){
9            for(int j=0;j<=n;j++){
10                if(i==0 && j==0) continue;
11                else if(i==0){
12                    dp[i][j] = grid[i][j] + dp[i][j-1];
13                }else if(j==0){
14                    dp[i][j] = grid[i][j] + dp[i-1][j];
15                }else{
16                    dp[i][j] = grid[i][j] + Math.min(dp[i-1][j],dp[i][j-1]);
17                }
18            }
19        }
20        return dp[m][n];
21    }
22}