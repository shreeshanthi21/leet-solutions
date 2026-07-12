// Last updated: 7/12/2026, 11:48:52 AM
1class Solution {
2    public int longestPalindromeSubseq(String s) {
3        int m=s.length();
4        String s2 = new StringBuilder(s).reverse().toString();;
5        int[][] dp=new int[m+1][m+1];
6        for(int i=0;i<m+1;i++){
7            for(int j=0;j<m+1;j++){
8                if(i==0 || j==0){
9                    dp[i][j]=0;
10                }
11            }
12        }
13        for(int i=1;i<m+1;i++){
14            for(int j=1;j<m+1;j++){
15                if(s.charAt(i-1)==s2.charAt(j-1)){
16                    dp[i][j]=dp[i-1][j-1]+1;
17                }
18                else{
19                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
20                }
21            }
22        }
23        return dp[m][m];
24    }
25}