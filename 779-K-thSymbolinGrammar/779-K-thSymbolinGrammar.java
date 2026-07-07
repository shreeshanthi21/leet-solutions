// Last updated: 7/7/2026, 8:03:14 AM
1class Solution {
2    public int kthGrammar(int n, int k) {
3        if(n==1 && k==1) return 0;
4        int mid=(int) Math.pow(2, n-1)/2;
5        if(k<=mid) return kthGrammar(n-1,k);
6        return 1-kthGrammar(n-1,k-mid);
7    }
8}