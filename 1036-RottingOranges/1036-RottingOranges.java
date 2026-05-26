// Last updated: 5/26/2026, 12:31:23 PM
class Solution {
    class Pair{
        int row;
        int col;
        int time;
        Pair(int row,int col,int time){
            this.row=row;
            this.col=col;
            this.time=time;
        }
    }
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<Pair> q=new LinkedList<>();
        int cntFresh=0;
        int[][] visited=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                    visited[i][j]=2;
                }
                else visited[i][j]=0;
                if(grid[i][j]==1) cntFresh++;
            }
        }
        int time=0;
        int[] drow={-1,0,+1,0};
        int[] dcol={0,+1,0,-1};
        int cnt=0;
        while(!q.isEmpty()){
            int r=q.peek().row;
            int c=q.peek().col;
            int t=q.peek().time;
            time=Math.max(t,time);
            q.poll();
            for(int i=0;i<4;i++){
                int currRow=r+drow[i];
                int currCol=c+dcol[i];
                if(currRow>=0 && currRow<m && currCol>=0 && currCol<n && visited[currRow][currCol]==0 && grid[currRow][currCol]==1){
                    q.add(new Pair(currRow,currCol,time+1));
                    visited[currRow][currCol]=2;
                    cnt++;
                }
            }
        }
        if(cnt!=cntFresh) return -1;
        return time;
    }
}