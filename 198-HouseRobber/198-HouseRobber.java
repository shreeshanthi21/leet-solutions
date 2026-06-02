// Last updated: 6/3/2026, 12:16:43 AM
1class Solution {
2    public int rob(int[] nums) {
3        int n=nums.length;
4        int prev=nums[0];
5        int prev2=0;
6        int maxi=Integer.MIN_VALUE;
7        for(int i=1;i<n;i++){
8            int pick=nums[i];
9            if(i>1) pick+=prev2;
10            int nopick=0+prev;
11            maxi=Math.max(pick,nopick);
12            prev2=prev;
13            prev=maxi;
14        }
15        return prev;
16    }
17}