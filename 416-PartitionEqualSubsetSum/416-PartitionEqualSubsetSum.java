// Last updated: 7/9/2026, 5:41:47 PM
1class Solution {
2    public boolean canPartition(int[] arr) {
3        int n=arr.length;
4        int sum=0;
5        for(int i:arr){
6            sum+=i;
7        }
8        if(sum%2!=0) return false;
9        int newSum=sum/2;
10        boolean[][] dp=new boolean[n+1][newSum+1];
11        for(int i=0;i<n+1;i++){
12            for(int j=0;j<newSum+1;j++){
13                if(i==0) dp[i][j]=false;
14                if(j==0) dp[i][j]=true;
15            }
16        }
17        
18        for(int i=1;i<n+1;i++){
19            for(int j=1;j<newSum+1;j++){
20                if(arr[i-1]<=j){
21                    dp[i][j]=dp[i-1][j-arr[i-1]] || dp[i-1][j];
22                }
23                else{
24                    dp[i][j]=dp[i-1][j];
25                }
26            }
27        }
28        return dp[n][newSum];
29    }
30}