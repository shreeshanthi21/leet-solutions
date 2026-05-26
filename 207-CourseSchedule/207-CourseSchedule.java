// Last updated: 5/26/2026, 8:21:52 PM
1class Solution {
2    public boolean canFinish(int numCourses, int[][] prerequisites) {
3        boolean[] visited=new boolean[numCourses];
4        boolean[] pathVisited=new boolean[numCourses];
5        for(int i=0;i<numCourses;i++){
6            if(!visited[i]){
7                if(dfs(i,prerequisites,visited,pathVisited)) return false;
8            }
9        }
10        return true;
11    }
12    public boolean dfs(int node, int[][] prerequisites, boolean[] visited, boolean[] pathVisited) {
13    visited[node] = true;
14    pathVisited[node] = true;
15    for (int i = 0; i < prerequisites.length; i++) {
16        if (prerequisites[i][1] == node) {
17            int neighbor = prerequisites[i][0];
18            if (pathVisited[neighbor]) {
19                return true; 
20            }
21            else if (!visited[neighbor]) {
22                if (dfs(neighbor, prerequisites, visited, pathVisited)) {
23                    return true;
24                }
25            }
26        }
27    }
28    pathVisited[node] = false;
29    return false;
30}
31}