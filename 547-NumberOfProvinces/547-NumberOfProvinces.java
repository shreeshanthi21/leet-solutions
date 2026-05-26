// Last updated: 5/26/2026, 12:31:31 PM
class Solution {
    int m;
    public void dfs(int[][] isConnected,boolean[] visited,int i){
        visited[i]=true;
        for(int j=0;j<m;j++){
            if(!visited[j] && isConnected[i][j]==1){
                dfs(isConnected,visited,j);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int count=0;
        m=isConnected.length;
        boolean[] visited=new boolean[m];
        for(int i=0;i<m;i++){
            if(!visited[i]){
                count++;
                dfs(isConnected,visited,i);
            }
        }
        return count;
    }
}