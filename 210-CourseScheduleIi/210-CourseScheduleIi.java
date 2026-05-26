// Last updated: 5/26/2026, 12:32:09 PM
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean[] visited=new boolean[numCourses];
        boolean[] pathVisited=new boolean[numCourses];
        boolean result=true;
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:prerequisites){
            adj.get(edge[1]).add(edge[0]);
        }
        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                if(dfs(i,-1,adj,visited,pathVisited)) { result=false;break;}
            }
        }
        if(!result) return new int[]{};
        boolean[] visited2=new boolean[numCourses];
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            if(!visited2[i]){
                dfsTraversal(i,adj,visited2,res);
            }
        }
        Collections.reverse(res);
        return res.stream()
               .mapToInt(Integer::intValue)
               .toArray();
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
    public void dfsTraversal(int node,List<List<Integer>> adj,boolean[] visited,List<Integer> res){
        visited[node]=true;
        for(int neighbor:adj.get(node)){
            if(!visited[neighbor]){
                dfsTraversal(neighbor,adj,visited,res);
            }
        }
        res.add(node);
    }
}