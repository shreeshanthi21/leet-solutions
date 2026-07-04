// Last updated: 7/4/2026, 8:05:21 PM
1class Solution {
2    public boolean isMiddleElementUnique(int[] nums) {
3        int n=nums.length/2;
4        int res=nums[n],c=0;        
5        for(int i:nums){
6            if(i==res && ++c>1) return false;
7        }
8        return true;
9        
10    }
11}