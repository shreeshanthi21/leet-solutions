// Last updated: 6/2/2026, 7:57:10 PM
1class Solution {
2
3    public int fn(int n,int[] dp){
4        if(n<=1) return 1;
5        if(dp[n]!=-1) return dp[n];
6        return dp[n]=fn(n-1,dp)+fn(n-2,dp);
7    }
8    public int climbStairs(int n) {
9       int[] dp=new int[n+1];
10       Arrays.fill(dp,-1);
11       return dp[n]=fn(n,dp);
12
13    }
14}