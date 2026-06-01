// Last updated: 6/1/2026, 9:34:41 PM
1class Solution {
2    public int swimInWater(int[][] grid) {
3        PriorityQueue<int[]> minheap=new PriorityQueue<>(
4            (a,b)->a[0]-b[0]
5        );
6        int n=grid.length;
7        minheap.add(new int[]{grid[0][0],0,0});
8        boolean[][] visited=new boolean[n][n];
9        visited[0][0]=true;
10        int[] dr={-1,0,+1,0};
11        int[] dc={0,+1,0,-1};
12        while(!minheap.isEmpty()){
13            int[] curr=minheap.poll();
14            int val=curr[0];int row=curr[1];int col=curr[2];
15            if(row==n-1 && col==n-1) return val;
16            for(int i=0;i<4;i++){
17                int newRow=row+dr[i];
18                int newCol=col+dc[i];
19                if(newRow>=0 && newRow<n && newCol>=0 && newCol<n && !visited[newRow][newCol]){
20                    visited[newRow][newCol]=true;
21                    minheap.add(new int[]{Math.max(val,grid[newRow][newCol]),newRow,newCol});
22                }
23            }
24        }
25        return -1;
26    }
27}