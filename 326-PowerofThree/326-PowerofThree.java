// Last updated: 7/6/2026, 9:50:40 AM
1class Solution {
2    public boolean isPowerOfThree(int n) {
3        if(n==1) return true;
4        if(n%3!=0 || n==0) return false;
5        return isPowerOfThree(n/3);
6    }
7}