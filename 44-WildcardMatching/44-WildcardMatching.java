// Last updated: 7/14/2026, 5:29:49 PM
1class Solution {
2    public boolean isMatch(String s, String p) {
3        int m=s.length();
4        int n=p.length();
5        boolean[][] dp=new boolean[m+1][n+1];
6        dp[0][0]=true;
7        for(int j=1;j<n+1;j++){
8            if(p.charAt(j-1)=='*') dp[0][j]=dp[0][j-1];
9        }
10        for(int i=1;i<m+1;i++){
11            for(int j=1;j<n+1;j++){
12                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?'){
13                    dp[i][j]=dp[i-1][j-1];
14                }else if(p.charAt(j-1)=='*') {
15                    dp[i][j]=dp[i-1][j] || dp[i][j-1];
16                }else{
17                    dp[i][j]=false;
18                }
19            }
20        }
21        return dp[m][n];
22    }
23}