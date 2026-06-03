// Last updated: 6/3/2026, 7:01:33 PM
1class Solution {
2    int func(int m, int n, int[][] dp) {
3        for (int i = 0; i < m; i++) {
4            for (int j = 0; j < n; j++) {
5                if (i == 0 && j == 0) {
6                    dp[i][j] = 1;
7                    continue; 
8                }
9                int up = 0;
10                int left = 0;
11                if (i > 0)
12                    up = dp[i - 1][j];
13                if (j > 0)
14                    left = dp[i][j - 1];
15                dp[i][j] = up + left;
16            }
17        }
18        return dp[m - 1][n - 1];
19    }
20    public int uniquePaths(int m, int n) {
21        int[][] dp = new int[m][n];
22        return func(m, n, dp);
23    }
24}