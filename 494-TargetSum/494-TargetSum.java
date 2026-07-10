// Last updated: 7/10/2026, 3:25:25 PM
1class Solution {
2    
3    public int findTargetSumWays(int[] arr, int target) {
4        int n = arr.length; // 'n' needs to be defined
5        int sum = 0;
6        for (int i : arr) sum += i;
7        
8        // Edge cases: target cannot be greater than total sum, or smaller than negative total sum
9        if (Math.abs(target) > sum) return 0;
10        
11        // (target + sum) must be even and non-negative
12        // Using 'target' instead of 'd', and Math.abs to safely handle negative modulo
13        if ((target + sum) < 0 || (target + sum) % 2 != 0) return 0;
14        
15        int t = (target + sum) / 2;
16        
17        // REDUCED: find count of subset with sum equal to t
18        int[][] dp = new int[n + 1][t + 1];
19        dp[0][0] = 1;
20        for (int i = 1; i < n + 1; i++) {
21            for (int j = 0; j < t + 1; j++) {
22                if (arr[i - 1] <= j)
23                    dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - arr[i - 1]]) % 1000000007;
24                else
25                    dp[i][j] = dp[i - 1][j];
26            }
27        }
28        return dp[n][t];
29    }
30}