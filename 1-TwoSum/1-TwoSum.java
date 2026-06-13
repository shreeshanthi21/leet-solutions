// Last updated: 6/13/2026, 9:10:32 PM
1class Solution {
2    public int[] twoSum(int[] nums, int target) {
3        HashMap<Integer, Integer> hm = new HashMap<>();
4        for (int i = 0; i < nums.length; i++) {
5            int complement = target - nums[i];
6            if (hm.containsKey(complement)) {
7                return new int[] { hm.get(complement), i };
8            }
9            hm.put(nums[i], i);
10        }
11        return new int[] {};
12    }
13}