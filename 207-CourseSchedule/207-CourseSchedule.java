// Last updated: 5/26/2026, 12:32:14 PM
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] visited=new boolean[numCourses];
        boolean[] pathVisited=new boolean[numCourses];
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:prerequisites){
            adj.get(edge[1]).add(edge[0]);
        }
        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                if(dfs(i,-1,adj,visited,pathVisited)) return false;
            }
        }
        return true;
    }
    public boolean dfs(int node,int prev,List<List<Integer>> adj,boolean[] visited,boolean[] pathVisited){
        visited[node]=true;
        pathVisited[node]=true;
        for(int neighbor:adj.get(node)){
            if(!visited[neighbor]){
                if(dfs(neighbor,node,adj,visited,pathVisited)) return true;
            }
            else if(pathVisited[neighbor]) return true;
        }
        pathVisited[node]=false;
        return false;
    }
}