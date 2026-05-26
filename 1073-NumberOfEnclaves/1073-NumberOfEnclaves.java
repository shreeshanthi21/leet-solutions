// Last updated: 5/26/2026, 12:31:21 PM
class Solution {
    int m;
    int n;
    public int numEnclaves(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        //boolean[][] visited=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                boolean border=(i==0 || i==m-1 || j==0 || j==n-1);
                if(border){
                    dfs(grid,i,j);
                }
            }
        }
        int result=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) result++;
            }
        }
        return result;
    }
    public void dfs(int[][] grid,int i,int j){
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j]!=1) return;
        grid[i][j]=Integer.MAX_VALUE;
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
}