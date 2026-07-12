// Last updated: 7/12/2026, 11:40:11 AM
1class Solution {
2    public int minDistance(String s1, String s2) {
3        int m=s1.length();
4        int n=s2.length();
5        int del=0;
6        int ins=0;
7        int[][] dp=new int[m+1][n+1];
8        for(int i=0;i<m+1;i++){
9            for(int j=0;j<n+1;j++){
10                if(i==0 || j==0) dp[i][j]=0;
11            }
12        }
13        for(int i=1;i<m+1;i++){
14            for(int j=1;j<n+1;j++){
15                if(s1.charAt(i-1)==s2.charAt(j-1)){
16                    dp[i][j]=1+dp[i-1][j-1];
17                }
18                else{
19                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
20                }
21            }
22        }
23        int LCS=dp[m][n];
24        del=m-LCS;
25        ins=n-LCS;
26        return del+ins;
27    }
28}