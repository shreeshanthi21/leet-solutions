// Last updated: 6/4/2026, 10:33:18 PM
1class Solution {
2    public int missingNumber(int[] nums) {
3        int n=nums.length;
4        HashSet<Integer> set=new HashSet<>();
5        for(int num:nums){
6            set.add(num);
7        }
8        for(int i=0;i<n;i++){
9            if(!set.contains(i)) return i;
10        }
11        return n;
12    }
13}