// Last updated: 6/2/2026, 7:59:26 PM
1class Solution {
2    public int climbStairs(int n) {
3        int[] dp=new int[n+1];
4        dp[0]=1;
5        dp[1]=1;
6        for(int i=2;i<=n;i++){
7            dp[i]=dp[i-1]+dp[i-2];
8        }       
9        return dp[n];
10    }
11}