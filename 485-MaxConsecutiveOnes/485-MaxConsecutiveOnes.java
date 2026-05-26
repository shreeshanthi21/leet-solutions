// Last updated: 5/26/2026, 12:31:39 PM
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int count = 0;
        
        for (int num : nums) {
            if (num == 1) {
                count++;
                // Update the maximum streak found so far
                maxCount = Math.max(maxCount, count);
            } else {
                // Streak is broken by a 0, reset the counter
                count = 0;
            }
        }
        
        return maxCount;
    }
}