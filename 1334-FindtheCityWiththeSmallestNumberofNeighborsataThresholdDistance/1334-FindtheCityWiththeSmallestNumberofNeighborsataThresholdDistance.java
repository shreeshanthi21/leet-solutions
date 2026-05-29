// Last updated: 5/30/2026, 1:16:29 AM
1class Solution {
2    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
3        int[][] distance=new int[n][n];
4        for(int i=0;i<n;i++){
5            for(int j=0;j<n;j++){
6                distance[i][j]=Integer.MAX_VALUE;
7                distance[i][i]=0;
8            }
9        }   
10        for(int[] edge:edges){
11            int u=edge[0];
12            int v=edge[1];
13            int wt=edge[2];
14            distance[u][v]=wt;
15            distance[v][u]=wt;
16        }
17        for(int via=0;via<n;via++){
18            for(int i=0;i<n;i++){
19                for(int j=0;j<n;j++){
20                    if(distance[i][via]==Integer.MAX_VALUE || distance[via][j]==Integer.MAX_VALUE) continue;
21                    distance[i][j]=Math.min(distance[i][j],distance[i][via]+distance[via][j]);
22                }
23            }
24        }
25        int mini=n;
26        int city=-1;
27        for(int row=0;row<n;row++){
28            int count=0;
29            for(int col=0;col<n;col++){
30                if(distance[row][col]<=distanceThreshold){
31                    count++;
32                }
33            }
34            if(mini>=count){
35                mini=count;
36                city=row;
37            }
38        }
39        return city;
40
41    }
42}