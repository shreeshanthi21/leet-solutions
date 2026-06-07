// Last updated: 6/7/2026, 8:59:09 AM
1class Solution {
2    public long maximumSum(int[] nums, int m, int l, int r) {
3        int n=nums.length;
4        long[] prefix=new long[n+1];
5        for(int i=0;i<n;i++){
6            prefix[i+1]=prefix[i]+nums[i];
7        }
8        int temp=n;
9        long[][] dp=new long[m+1][n+1];
10        for (int i = 1; i <= m; i++) {
11            Arrays.fill(dp[i], Long.MIN_VALUE / 2); 
12        }
13        for(int count=1;count<=m;count++){
14            Deque<Integer>  dq=new ArrayDeque<>();
15            for(int j=1;j<=n;j++){
16                dp[count][j]=dp[count][j-1];
17                int valid=j-l;
18                if(valid>=0){
19                    while(!dq.isEmpty() && getVal(dp[count-1],prefix,dq.peekLast())<= getVal(dp[count-1],prefix,valid)){
20                        dq.pollLast();
21                    }
22                    dq.addLast(valid);
23                }
24                while(!dq.isEmpty() && dq.peekFirst()<j-r){
25                    dq.pollFirst();
26                }
27                if(!dq.isEmpty()){
28                    int best=dq.peekFirst();
29                    long curr=prefix[j]-prefix[best];
30                    dp[count][j]=Math.max(dp[count][j],dp[count-1][best]+curr);
31                }
32            }
33        }
34        long res=Long.MIN_VALUE;
35        for(int i=1;i<=m;i++){
36            res=Math.max(res,dp[i][n]);
37        }
38        return res;
39    }
40    private long getVal(long[] prevdp,long[] prefix,int k){
41        return prevdp[k]-prefix[k];
42    }
43}