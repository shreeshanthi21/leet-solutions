// Last updated: 7/11/2026, 5:54:54 PM
1class Solution {
2    public int longestCommonSubsequence(String text1, String text2) {
3        int m=text1.length();
4        int n=text2.length();
5        int[][] dp=new int[m+1][n+1];
6        for(int i=0;i<m+1;i++){
7            for(int j=0;j<n+1;j++){
8                if(i==0 || j==0) dp[i][j]=0;
9            }
10        }
11        for(int i=1;i<m+1;i++){
12            for(int j=1;j<n+1;j++){
13                if(text1.charAt(i-1)==text2.charAt(j-1)){
14                    dp[i][j]=1+dp[i-1][j-1];
15                }
16                else{
17                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
18                }
19            }
20        }
21        return dp[m][n];
22    }
23}