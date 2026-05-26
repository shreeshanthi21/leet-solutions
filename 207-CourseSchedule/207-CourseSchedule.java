// Last updated: 5/26/2026, 8:22:41 PM
1class Solution {
2    public boolean canFinish(int numCourses, int[][] prerequisites) {
3        boolean[] visited=new boolean[numCourses];
4        boolean[] pathVisited=new boolean[numCourses];
5        List<List<Integer>> adj=new ArrayList<>();
6        for(int i=0;i<numCourses;i++){
7            adj.add(new ArrayList<>());
8        }
9        for(int[] edge:prerequisites){
10            adj.get(edge[1]).add(edge[0]);
11        }
12        for(int i=0;i<numCourses;i++){
13            if(!visited[i]){
14                if(dfs(i,-1,adj,visited,pathVisited)) return false;
15            }
16        }
17        return true;
18    }
19    public boolean dfs(int node,int prev,List<List<Integer>> adj,boolean[] visited,boolean[] pathVisited){
20        visited[node]=true;
21        pathVisited[node]=true;
22        for(int neighbor:adj.get(node)){
23            if(!visited[neighbor]){
24                if(dfs(neighbor,node,adj,visited,pathVisited)) return true;
25            }
26            else if(pathVisited[neighbor]) return true;
27        }
28        pathVisited[node]=false;
29        return false;
30    }
31}