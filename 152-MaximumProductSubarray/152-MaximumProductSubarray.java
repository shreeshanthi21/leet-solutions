// Last updated: 5/26/2026, 12:32:30 PM
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int prod = 1;
            for (int j = i; j < n; j++) {
                prod *= nums[j];
                max = Math.max(max, prod);
            }
        }

        return max;
    }
}
