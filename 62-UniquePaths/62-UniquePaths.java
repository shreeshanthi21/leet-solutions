// Last updated: 6/3/2026, 6:59:42 PM
1class Solution {
2     private int func(int i, int j, int[][] dp) {
3        if (i == 0 && j == 0) return 1;
4        if (i < 0 || j < 0) return 0;
5        if (dp[i][j] != -1)
6            return dp[i][j];
7        int up = func(i - 1, j, dp);
8        int left = func(i, j - 1, dp);
9        return dp[i][j] = up + left;
10    }
11    public int uniquePaths(int m, int n) {
12        int dp[][] = new int[m][n];
13        for (int[] row : dp)
14            Arrays.fill(row, -1);
15        return func(m - 1, n - 1, dp);
16    }
17}