// Last updated: 6/3/2026, 12:47:53 AM
1class Solution {
2
3    private int func(int ind, int[] arr, int[] dp) {
4        // Base cases
5        if (ind == 0)
6            return arr[ind];
7        if (ind < 0)
8            return 0;
9        if (dp[ind] != -1) {
10            return dp[ind];
11        }
12        int pick = arr[ind] + func(ind - 2, arr, dp);
13        int nonPick = func(ind - 1, arr, dp);
14        return dp[ind] = Math.max(pick, nonPick);
15    }
16
17    public int rob(int[] money) {
18        int n = money.length;
19        if (n == 0)
20            return 0;
21        if (n == 1)
22            return money[0];
23
24        int[] arr1 = new int[n - 1];
25        int[] arr2 = new int[n - 1];
26        for (int i = 0; i < n; i++) {
27            if (i != n - 1)
28                arr1[i] = money[i];
29            if (i != 0)
30                arr2[i - 1] = money[i];
31        }
32        int[] dp1 = new int[n];
33        Arrays.fill(dp1, -1);
34        int ans1 = func(arr1.length - 1, arr1, dp1);
35
36        int[] dp2 = new int[n];
37        Arrays.fill(dp2, -1);
38        int ans2 = func(arr2.length - 1, arr2, dp2);
39        return Math.max(ans1, ans2);
40    }
41}