// Last updated: 7/6/2026, 9:53:15 AM
class Solution {
    public int fib(int n) {
        if (n < 2) return n;
        return fib(n - 1) + fib(n - 2);
    }
}