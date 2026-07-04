// Last updated: 7/4/2026, 8:10:23 PM
1class Solution {
2    public int maxValidPairSum(int[] nums, int k) {
3        int res=0,mx=nums[0];
4        for(int j=k;j<nums.length;j++){
5            mx=Math.max(mx,nums[j-k]);
6            res=Math.max(res,mx+nums[j]);
7        }
8        return res;
9    }
10}