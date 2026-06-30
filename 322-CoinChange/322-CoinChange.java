// Last updated: 6/30/2026, 9:21:57 PM
1class Solution {
2    final int mod = (int)1e9 + 7;
3    private int func(int[] arr, int ind, int T, int[][] dp) {
4        if (ind == 0) {
5            if (T % arr[0] == 0)
6                return T / arr[0];
7            else
8                return (int)1e9;
9        }
10        if (dp[ind][T] != -1)
11            return dp[ind][T];
12        int notTaken = func(arr, ind - 1, T, dp);
13        int taken = (int)1e9;
14        if (arr[ind] <= T)
15            taken = 1 + func(arr, ind, T - arr[ind], dp);
16        return dp[ind][T] = Math.min(notTaken, taken);
17    }
18
19    public int coinChange(int[] coins, int amount) {
20        int n = coins.length;
21        int[][] dp = new int[n][amount + 1];
22        for (int[] row : dp)
23            Arrays.fill(row, -1);
24        int ans = func(coins, n - 1, amount, dp);
25        if (ans >= (int)1e9)
26            return -1;
27        return ans;
28    }
29}