// Last updated: 6/7/2026, 8:05:52 AM
1class Solution {
2    public int sumOfGoodIntegers(int n, int k) {
3        int res=0;
4        int begin=Math.max(1,n-k);
5        int end=n+k;
6        for(int i=begin;i<=end;i++){
7            if((n&i) == 0) res+=i;
8        }
9        return res;
10    }
11}