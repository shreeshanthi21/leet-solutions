// Last updated: 5/26/2026, 12:31:35 PM
class Solution {
    class Pair{
        int row;
        int col;
        int dist;
        Pair(int row,int col,int dist){
            this.row=row;
            this.col=col;
            this.dist=dist;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        Queue<Pair> q=new LinkedList<>();
        boolean[][] visited=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.add(new Pair(i,j,0));
                    visited[i][j]=true;
                }
            }
        }
        int[] drow={-1,0,+1,0};
        int[] dcol={0,+1,0,-1};
        while(!q.isEmpty()){
            Pair curr=q.poll();
            int row=curr.row;
            int col=curr.col;
            int dist=curr.dist;
            for(int i=0;i<4;i++){
                int nrow=row+drow[i];
                int ncol=col+dcol[i];
                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && !visited[nrow][ncol] && mat[nrow][ncol]==1){
                    visited[nrow][ncol]=true;
                    mat[nrow][ncol]=dist+1;
                    q.add(new Pair(nrow,ncol,dist+1));
                }
            }
        }
        return mat;
    }
}