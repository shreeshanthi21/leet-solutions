// Last updated: 6/1/2026, 1:26:21 PM
1class Solution {
2    class DisjointSet{
3        int[] size;
4        int[] parent;
5        public DisjointSet(int n){
6            size=new int[n+1];
7            parent=new int[n+1];
8            Arrays.fill(size,1);
9            for(int i=0;i<=n;i++){
10                parent[i]=i;
11            }
12        }
13        public int FindParent(int u){
14            if(u==parent[u]) return u;
15            return parent[u]=FindParent(parent[u]);
16        }
17        public void unionBySize(int u,int v){
18            int ulp_u=FindParent(u);
19            int ulp_v=FindParent(v);
20            if(ulp_u==ulp_v) return;
21            if(size[ulp_u]>=size[ulp_v]) {
22                parent[ulp_v]=ulp_u;
23                size[ulp_u]+=size[ulp_v];
24            }
25            else{
26                parent[ulp_u]=ulp_v;
27                size[ulp_v]+=size[ulp_u];
28            }
29        } 
30    }
31    public int removeStones(int[][] stones) {
32        int maxRow=0;
33        int maxCol=0;
34        int n=stones.length;
35        for(int i=0;i<n;i++){
36            maxRow=Math.max(maxRow,stones[i][0]);
37            maxCol=Math.max(maxCol,stones[i][1]);
38        }
39        DisjointSet ds=new DisjointSet(maxRow+maxCol+1);
40        HashMap<Integer,Integer> hm=new HashMap<>();
41        for(int i=0;i<n;i++){
42            int nodeRow=stones[i][0];
43            int nodeCol=stones[i][1]+maxRow+1;
44            ds.unionBySize(nodeRow,nodeCol);
45            hm.put(nodeRow,1);
46            hm.put(nodeCol,1);
47        }
48        int count=0;
49        for(Map.Entry<Integer,Integer> it:hm.entrySet()){
50            if(ds.FindParent(it.getKey())==it.getKey()){
51                count++;
52            }
53        }
54        return n-count;
55    }
56}