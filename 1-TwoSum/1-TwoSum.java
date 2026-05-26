// Last updated: 5/26/2026, 12:35:05 PM
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (hm.containsKey(complement)) {
                return new int[] { hm.get(complement), i };
            }
            hm.put(nums[i], i);
        }
        return new int[] {};
    }
}