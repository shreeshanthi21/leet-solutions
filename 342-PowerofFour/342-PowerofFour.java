// Last updated: 7/6/2026, 9:51:31 AM
1class Solution {
2    public boolean isPowerOfFour(int n) {
3        if(n==1) return true;
4        if(n%4!=0 || n==0) return false;
5        return isPowerOfFour(n/4);
6    }
7}