// Last updated: 7/14/2026, 5:21:05 PM
1class Solution {
2    int[][] dp;
3    public int solve(int[] nums,int i,int j){
4        if(i>j) return 0;
5        if(dp[i][j]!=-1) return dp[i][j];
6        int mini=0;
7        for (int k = i; k <= j; k++) {
8            int temp = solve(nums, i, k - 1) + solve(nums, k + 1, j) + nums[i - 1] * nums[k] * nums[j + 1];
9    
10            if (temp > mini) mini = temp; 
11        }
12        return dp[i][j]=mini;
13    }
14    public int maxCoins(int[] nums) {
15        int n = nums.length;
16        dp = new int[n + 2][n + 2];
17        for(int i = 0; i < n + 2; i++) {
18            Arrays.fill(dp[i], -1);
19        }
20        int[] padded = new int[n + 2];
21        padded[0] = 1;
22        padded[n + 1] = 1;
23        for (int i = 0; i < n; i++) padded[i + 1] = nums[i];
24        return solve(padded, 1, n);
25    }
26}