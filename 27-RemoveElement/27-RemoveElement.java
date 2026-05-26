// Last updated: 5/26/2026, 12:34:26 PM
class Solution {
    public int removeElement(int[] nums, int val) {
           int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;    
    }
}