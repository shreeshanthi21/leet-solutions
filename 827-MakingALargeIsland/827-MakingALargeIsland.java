// Last updated: 6/1/2026, 8:07:26 PM
1class Solution {
2    class DisjointSet{
3        int[] size;
4        int [] parent;
5        public DisjointSet(int n){
6            size=new int[n+1];
7            parent=new int[n+1];
8            for(int i=0;i<=n;i++){
9                size[i]=1;
10                parent[i]=i;
11            }
12        }
13        public int findparent(int u){
14            if(u==parent[u]) return u;
15            return parent[u]=findparent(parent[u]);
16        }
17        public void unionbysize(int u,int v){
18            int ulp_u=findparent(u);
19            int ulp_v=findparent(v);
20            if(ulp_u==ulp_v) return;
21            if(size[ulp_u]>=size[ulp_v]){
22                parent[ulp_v]=ulp_u;
23                size[ulp_u]+=size[ulp_v];
24            }else{
25                parent[ulp_u]=ulp_v;
26                size[ulp_v]+=size[ulp_u];
27            }
28        }
29    }
30    private boolean isValid(int i, int j, int n) {
31        if (i < 0 || i >= n) return false;
32        if (j < 0 || j >= n) return false;
33        return true;
34    }
35    public int largestIsland(int[][] grid) {
36        int n=grid.length;
37        DisjointSet ds=new DisjointSet(n*n);
38        for(int i=0;i<n;i++){
39            for(int j=0;j<n;j++){
40                if(grid[i][j]==0) continue;
41                int[] dr={-1,0,+1,0};
42                int[] dc={0,+1,0,-1};
43                for(int idx=0;idx<4;idx++){
44                    int newRow=i+dr[idx];
45                    int newCol=j+dc[idx];
46                    if(isValid(newRow,newCol,n) && (grid[newRow][newCol]==1)){
47                        int newNode=i*n+j;
48                        int adjNode=newRow*n+newCol;
49                        ds.unionbysize(newNode,adjNode);
50                    }
51                }
52            }
53        }
54        int maxi=0;
55        for(int i=0;i<n;i++){
56            for(int j=0;j<n;j++){
57                if(grid[i][j]==1) continue;
58                int[] dr={-1,0,+1,0};
59                int[] dc={0,+1,0,-1};
60                HashSet<Integer> components=new HashSet<>();
61                for(int idx=0;idx<4;idx++){
62                    int newRow=i+dr[idx];
63                    int newCol=j+dc[idx];
64                    if(isValid(newRow,newCol,n) && (grid[newRow][newCol]==1)){
65                        components.add(ds.findparent(newRow*n+newCol));
66                    }
67                }
68                int total=0;
69                for(int parents:components){
70                    total+=ds.size[parents];
71                }
72                maxi=Math.max(maxi,total+1);
73            }
74            
75        }
76        for(int i=0;i<n*n;i++){
77            maxi=Math.max(maxi,ds.size[ds.findparent(i)]);
78        }
79        return maxi;
80    }
81}