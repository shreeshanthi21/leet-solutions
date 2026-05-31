// Last updated: 5/31/2026, 11:08:35 PM
1class Solution {
2    int[] size;
3    int[] parent;
4    public void disjointSet(int n){
5        size=new int[n+1];
6        parent=new int[n+1];
7        for(int i=0;i<n;i++){
8            parent[i]=i;
9        }
10        Arrays.fill(size,1);
11    }
12    public int findUparent(int u){
13        if(u==parent[u]) return u;
14        return parent[u]=findUparent(parent[u]);
15    }
16    public boolean unionBysize(int u,int v){
17        int ulp_u=findUparent(u);
18        int ulp_v=findUparent(v);
19        if(ulp_u==ulp_v) return false;
20        if(size[ulp_u]>=size[ulp_v]){
21            parent[ulp_v]=ulp_u;
22            size[ulp_u]+=size[ulp_v];
23        }
24        else{
25            parent[ulp_u]=ulp_v;
26            size[ulp_v]+=size[ulp_u];
27        } 
28        return true;
29    }
30    public int makeConnected(int n, int[][] connections) {
31        int m=connections.length;
32        if(n-1>m) return -1;
33        disjointSet(n);
34        int nodes_connected=1;
35        for(int[] c:connections){
36            if(unionBysize(c[0],c[1])){
37                nodes_connected++;
38            }
39        }
40        return n-nodes_connected;
41    }
42}