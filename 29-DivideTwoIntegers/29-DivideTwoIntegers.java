// Last updated: 5/26/2026, 12:34:23 PM
class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE; 
        }
        double ans=(dividend/divisor);
        int ans1=(int) ans;
        return ans1;
    }
}