// Last updated: 6/3/2026, 12:10:17 AM
1class Solution {
2    public int rob(int[] nums) {
3        int n=nums.length;
4        int[] dp=new int[n+1];
5        dp[0]=nums[0];
6        for(int i=1;i<n;i++){
7            int pick=nums[i];
8            if(i>1) pick+=dp[i-2];
9            int nopick=dp[i-1];
10            dp[i]=Math.max(pick,nopick);
11        }
12        return dp[n-1];
13    }
14}