// Last updated: 5/26/2026, 2:49:02 PM
class Solution {
    public boolean isBipartite(int[][] graph) {
        int V=graph.length;
        int[] color=new int[V];
        for(int i=0;i<V;i++){
            if(color[i]==0 && !dfs(i,graph,color,1)) return false;
        }
        return true;
    }

    public boolean dfs(int node,int[][] graph,int[] color, int toColor){
        if(color[node]!=0) return color[node]==toColor;
        color[node]=toColor;
        int[] children=graph[node];
        for(int child:children){
            if(!dfs(child,graph,color,-toColor)) return false;
        }
        return true;
    }
}