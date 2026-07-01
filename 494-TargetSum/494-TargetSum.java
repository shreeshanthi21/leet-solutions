// Last updated: 7/1/2026, 7:37:32 PM
1class Solution {
2    private static final int MOD = (int)1e9 + 7;
3    private int func(int[] arr, int target) {
4        int n = arr.length;
5        int[][] dp = new int[n][target + 1];
6
7        if (arr[0] == 0) 
8            dp[0][0] = 2;   
9        else
10            dp[0][0] = 1;  
11
12        if (arr[0] != 0 && arr[0] <= target)
13            dp[0][arr[0]] = 1;  
14
15        for (int ind = 1; ind < n; ind++) {
16            for (int tar = 0; tar <= target; tar++) {
17                int notTaken = dp[ind - 1][tar];
18
19                int taken = 0;
20                if (arr[ind] <= tar)
21                    taken = dp[ind - 1][tar - arr[ind]];
22
23                dp[ind][tar] = (notTaken + taken) % MOD;
24            }
25        }
26        return dp[n - 1][target];
27    }
28    public int findTargetSumWays(int[] nums, int target) {
29        int totSum = 0;
30        for (int num : nums) {
31            totSum += num;
32        }
33        if (totSum - target < 0 || (totSum - target) % 2 != 0)
34            return 0;  
35
36        return func(nums, (totSum - target) / 2);
37    }
38}