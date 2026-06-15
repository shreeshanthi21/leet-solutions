// Last updated: 6/15/2026, 10:12:18 PM
1class Solution {
2    public long maxRatings(int[][] units) {
3        int m=units.length;
4        int n=units[0].length;
5        if(n==1){
6            long res=0;
7            for(int i=0;i<m;i++){
8                res+=units[i][0];
9            }
10            return res;
11        }
12        long sum=0;
13        int mini=Integer.MAX_VALUE;
14        int mini2= Integer.MAX_VALUE;
15        for(int i=0;i<m;i++){
16            int first=Integer.MAX_VALUE;
17            int second=Integer.MAX_VALUE;
18            for(int x:units[i]){
19                if(x<first){
20                    second=first;
21                    first=x;
22                }else if(x<second){
23                    second=x;
24                }
25            }
26            mini=Math.min(mini,first);
27            mini2=Math.min(mini2,second);
28            sum+=second;
29        }
30        return sum-mini2+mini;
31    }
32}