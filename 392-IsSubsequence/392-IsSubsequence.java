// Last updated: 7/13/2026, 7:15:15 PM
1class Solution {
2    public boolean isSubsequence(String s, String t) {
3        int m=s.length();
4        int n=t.length();
5        int[][] dp=new int[m+1][n+1];
6        for(int i=0;i<m+1;i++){
7            for(int j=0;j<n+1;j++){
8                if(i==0 || j==0) dp[i][j]=0;
9            }
10        }
11        for(int i=1;i<m+1;i++){
12            for(int j=1;j<n+1;j++){
13                if(s.charAt(i-1)==t.charAt(j-1)){
14                    dp[i][j]=1+dp[i-1][j-1];
15                }
16                else{
17                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
18                }
19            }
20        }
21        if(m!=dp[m][n]) return false;
22        return true;
23    }
24}