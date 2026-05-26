// Last updated: 5/26/2026, 12:34:55 PM
class Solution {
    public int reverse(int x) {
        if (x == Integer.MAX_VALUE || x == Integer.MIN_VALUE) return 0;
        int r;
        int res = 0;
        while (x != 0) {
            r = x % 10;

            // Overflow check
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && r > 7)) return 0;
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && r < -8)) return 0;

            res = res * 10 + r;
            x /= 10;
        }
        return res;
    }
}
