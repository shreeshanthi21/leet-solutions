// Last updated: 7/10/2026, 5:05:40 PM
1class Solution {
2    public int coinChange(int[] coins, int amount) {
3        int n=coins.length;
4        int[][] dp=new int[n+1][amount+1];
5        //change in initialization
6        for(int i=0;i<n+1;i++){
7            for(int j=0;j<amount+1;j++){
8                if(j==0) dp[i][j]=0;
9                if(i==0) dp[i][j]=amount+1;
10            }
11        }
12        
13        for(int i=1;i<n+1;i++){
14            for(int j=1;j<amount+1;j++){
15                if(coins[i-1]<=j){
16                    dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j]);
17                }
18                else{
19                    dp[i][j]=dp[i-1][j];
20                }
21            }
22        }
23        return dp[n][amount]>amount?-1:dp[n][amount];
24    }
25}