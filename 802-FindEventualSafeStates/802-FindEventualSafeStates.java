// Last updated: 5/26/2026, 11:49:03 PM
1class Solution {
2    public List<Integer> eventualSafeNodes(int[][] graph) {
3        int[] visited=new int[graph.length];
4        List<Integer> result=new ArrayList<>();
5        for(int i=0;i<graph.length;i++){
6            if(dfs(i,graph,visited)){
7                result.add(i);
8            }
9        }
10        return result;
11    }
12    public boolean dfs(int node,int[][] graph,int[] visited){
13        if(visited[node]==2) return true;
14        if(visited[node]==1) return false;
15        visited[node]=1;
16        for(int neighbor:graph[node]){
17            if(!dfs(neighbor,graph,visited)) return false;
18        }
19        visited[node]=2;
20        return true;
21    }   
22}