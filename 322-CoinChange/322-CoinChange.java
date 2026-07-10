// Last updated: 7/10/2026, 4:54:49 PM
1class Solution {
2    public int coinChange(int[] coins, int amount) {
3        int n=coins.length;
4        int[][] dp=new int[n+1][amount+1];
5        
6        for (int j = 0; j <= amount; j++) {
7            dp[0][j] = amount + 1; 
8        }
9        
10        // 0 coins are needed to make an amount of 0
11        for (int i = 0; i <= n; i++) {
12            dp[i][0] = 0;
13        }
14        
15        for(int i=1;i<n+1;i++){
16            for(int j=1;j<amount+1;j++){
17                if(coins[i-1]<=j){
18                    dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j]);
19                }
20                else{
21                    dp[i][j]=dp[i-1][j];
22                }
23            }
24        }
25        return dp[n][amount]>amount?-1:dp[n][amount];
26    }
27}