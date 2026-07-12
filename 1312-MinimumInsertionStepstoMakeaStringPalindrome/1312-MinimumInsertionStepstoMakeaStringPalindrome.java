// Last updated: 7/12/2026, 11:58:29 AM
1class Solution {
2    public int minInsertions(String s) {
3        int m=s.length();
4        String s2=new StringBuilder(s).reverse().toString();
5        int ins=0;
6        int[][] dp=new int[m+1][m+1];
7        for(int i=0;i<m+1;i++){
8            for(int j=0;j<m+1;j++){
9                if(i==0 || j==0) dp[i][j]=0;
10            }
11        }
12        for(int i=1;i<m+1;i++){
13            for(int j=1;j<m+1;j++){
14                if(s.charAt(i-1)==s2.charAt(j-1)){
15                    dp[i][j]=1+dp[i-1][j-1];
16                }
17                else{
18                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
19                }
20            }
21        }
22        int LCS=dp[m][m];
23        ins=m-LCS;
24        return ins;
25    }
26}