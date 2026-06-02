// Last updated: 6/3/2026, 12:05:44 AM
1class Solution {
2    public int fn(int n,int[] nums,int[] dp){
3        if(n<0) return 0;
4        if(n==0) return nums[0];
5        if(dp[n]!=-1) return dp[n];
6        int pick=nums[n]+fn(n-2,nums,dp);
7        int nopick=fn(n-1,nums,dp);
8        int maxi=Math.max(pick,nopick);
9        return dp[n]=maxi;
10    }
11    public int rob(int[] nums) {
12        int n=nums.length;
13        int[] dp=new int[n+1];
14        Arrays.fill(dp,-1);
15        return fn(n-1,nums,dp);
16    }
17}