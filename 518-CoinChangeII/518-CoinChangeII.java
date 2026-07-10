// Last updated: 7/10/2026, 4:49:08 PM
1class Solution {
2    public int change(int amount, int[] coins) {
3        int n=coins.length;
4        int[][] dp=new int[n+1][amount+1];
5        for(int i=0;i<n+1;i++){
6            for(int j=0;j<amount+1;j++){
7                if(i==0) dp[i][j]=0;
8                if(j==0) dp[i][j]=1;
9            }
10        }
11        for(int i=1;i<n+1;i++){
12            for(int j=1;j<amount+1;j++){
13                if(coins[i-1]<=j){
14                    dp[i][j]=dp[i][j-coins[i-1]]+dp[i-1][j];
15                }
16                else{
17                    dp[i][j]=dp[i-1][j];
18                }
19            }
20        }
21        return dp[n][amount];
22    }
23}