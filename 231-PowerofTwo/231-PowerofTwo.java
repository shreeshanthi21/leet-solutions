// Last updated: 7/6/2026, 9:49:03 AM
1class Solution {
2    public boolean isPowerOfTwo(int n) {
3        if(n==1) return true;
4        else if(n==0) return false;
5        if(n%2!=0) return false;
6        return isPowerOfTwo(n/2);
7    }
8}