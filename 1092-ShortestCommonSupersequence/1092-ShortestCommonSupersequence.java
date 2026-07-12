// Last updated: 7/12/2026, 10:55:51 AM
1class Solution {
2    public String shortestCommonSupersequence(String str1, String str2) {
3        int m=str1.length();
4        int n=str2.length();
5        int[][] dp=new int[m+1][n+1];
6        for(int i=0;i<m+1;i++){
7            for(int j=0;j<n+1;j++){
8                if(i==0 || j==0) dp[i][j]=0;
9            }
10        }
11        for(int i=1;i<m+1;i++){
12            for(int j=1;j<n+1;j++){
13                if(str1.charAt(i-1)==str2.charAt(j-1)) dp[i][j]=1+dp[i-1][j-1];
14                else{
15                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
16                }
17            }
18        }
19        //for size of the scs
20        //return m+n-dp[m][n];
21        String res="";
22        int i=m,j=n;
23        while(i>0 &&j>0){
24            if(str1.charAt(i-1)==str2.charAt(j-1)){
25                res=str1.charAt(i-1)+res;
26                i--;j--;
27            }
28            else if(dp[i-1][j]>=dp[i][j-1]){
29                res=str1.charAt(i-1)+res;i--;
30            }else{
31                res=str2.charAt(j-1)+res;j--;
32            }
33        }
34        while(i>0){
35            res=str1.charAt(i-1)+res;i--;
36        }
37        while(j>0){
38            res=str2.charAt(j-1)+res;j--;
39        }
40        return res;
41    }
42}