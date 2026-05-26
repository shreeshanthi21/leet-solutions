// Last updated: 5/26/2026, 12:31:13 PM
class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[2 * n];
        
        for (int i = 0; i < n; i++) {
            result[2 * i] = nums[i];         // Places x1, x2, x3...
            result[2 * i + 1] = nums[i + n]; // Places y1, y2, y3...
        }
        
        return result;
    }
}