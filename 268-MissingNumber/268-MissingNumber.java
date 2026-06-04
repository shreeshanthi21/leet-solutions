// Last updated: 6/4/2026, 10:34:42 PM
1class Solution {
2    public int missingNumber(int[] nums) {
3        int n=nums.length;
4        int sum=n*(n+1)/2;
5        int curr=0;
6        for(int i=0;i<n;i++){
7            curr+=nums[i];
8        }
9        return sum-curr;
10    }
11}