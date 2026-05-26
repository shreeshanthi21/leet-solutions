// Last updated: 5/26/2026, 12:32:51 PM
class Solution {
    int m;
    int n;
    
    public void solve(char[][] grid) {
        m=grid.length;
        if(m==0) return;
        n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                boolean border=(i==0 || i==m-1 || j==0 || j==n-1);
                if(grid[i][j]=='O' && border){
                    dfs(grid,i,j);
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='O') grid[i][j]='X';
                else if(grid[i][j]=='#') grid[i][j]='O';
            }
        }

    }
    
    public void dfs(char[][] grid, int i, int j) {
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j]!='O') return;
        grid[i][j]='#';
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    } 
}