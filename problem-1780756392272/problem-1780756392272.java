// Last updated: 6/6/2026, 8:03:12 PM
1class Solution {
2    public boolean consecutiveSetBits(int n) {
3        int x=n & (n>>1);
4        return x!=0 && (x & (x-1))==0;
5    }
6}