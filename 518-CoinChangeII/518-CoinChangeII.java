// Last updated: 6/30/2026, 9:43:57 PM
1class Solution {
2    public int change(int amount, int[] coins) {
3        int n = coins.length;
4        int[][] dp = new int[n + 1][amount + 1];
5        for (int i = 0; i <= n; i++) dp[i][0] = 1;
6
7        for (int i = 1; i <= n; i++) {
8            for (int j = 1; j <= amount; j++) {
9                if (coins[i - 1] <= j) {
10                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
11                } else {
12                    dp[i][j] = dp[i - 1][j];
13                }
14            }
15        }
16        return dp[n][amount];
17    }
18}