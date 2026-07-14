// Last updated: 7/14/2026, 8:00:39 AM
1class Solution {
2    public int numDistinct(String s, String t) {
3        int m=s.length();
4        int n=t.length();
5        int[][] dp=new int[m+1][n+1];
6        for (int i = 0; i <= m; i++) {
7            dp[i][0] = 1;
8        }
9        for(int i=1;i<m+1;i++){
10            for(int j=1;j<n+1;j++){
11                if(s.charAt(i-1)==t.charAt(j-1)){
12                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
13                } else{
14                    dp[i][j] = dp[i - 1][j];
15                }
16            }
17        }
18        return dp[m][n];
19    }
20}
21