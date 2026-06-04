// Last updated: 6/4/2026, 10:30:21 PM
1class Solution {
2    public int missingNumber(int[] nums) {
3        Arrays.sort(nums);
4        if(nums[0]!=0) return 0;
5        for(int i=1;i<nums.length;i++){
6            if(nums[i]!=i) return i;
7        }
8        return nums.length;
9    }
10}