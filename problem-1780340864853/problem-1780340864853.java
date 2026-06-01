// Last updated: 6/2/2026, 12:37:44 AM
1class Solution {
2    int timer=0;
3    public void dfs(int node,int parent,int[] time,int[] low,List<List<Integer>> bridges,List<List<Integer>> adj,boolean[] visited){
4        visited[node]=true;
5        time[node]=timer;
6        low[node]=timer;
7        timer++;
8        for(int neighbor:adj.get(node)){
9            if(neighbor==parent) continue;
10            if(!visited[neighbor]){
11                dfs(neighbor,node,time,low,bridges,adj,visited);
12                low[node]=Math.min(low[node],low[neighbor]);
13                if(low[neighbor]>time[node]){
14                    bridges.add(Arrays.asList(neighbor,node));
15                }
16            }
17            else{
18                low[node]=Math.min(low[node],low[neighbor]);
19            }
20        }
21    }
22
23    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
24        List<List<Integer>> adj=new ArrayList<>();
25        for(int i=0;i<n;i++){
26            adj.add(new ArrayList<>());
27        }
28        for(List<Integer> i:connections){
29            int u=i.get(0);int v=i.get(1);
30            adj.get(u).add(v);
31            adj.get(v).add(u);
32        }
33        int[] time=new int[n];
34        int[] low=new int[n];
35        boolean[] visited=new boolean[n];
36        List<List<Integer>> bridges=new ArrayList<>();
37        dfs(0,-1,time,low,bridges,adj,visited);
38        return bridges;
39    }
40}