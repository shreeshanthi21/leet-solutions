// Last updated: 5/29/2026, 7:10:15 PM
1class Solution {
2    int[] dir=new int[] {0,1,0,-1,0};
3    public int minimumEffortPath(int[][] heights) {
4        int m=heights.length;
5        int n=heights[0].length;
6        int[][] distance=new int[m][n];
7        for(int i=0;i<m;i++) Arrays.fill(distance[i],Integer.MAX_VALUE);
8        distance[0][0]=0;
9        PriorityQueue<int[]> minheap=new PriorityQueue<>(
10            Comparator.comparingInt(a->a[0])
11        );
12        minheap.offer(new int[]{0,0,0});
13        while(!minheap.isEmpty()){
14            int[] curr=minheap.poll();
15            int dist=curr[0];
16            int row=curr[1];
17            int col=curr[2];
18            if(dist>distance[row][col]) continue;
19            if(row==m-1 && col==n-1) return dist;
20            for(int i=0;i<4;i++){
21                int newRow=row+dir[i];
22                int newCol=col+dir[i+1];
23                if(newRow>=0 && newRow<m && newCol>=0 && newCol<n){
24                    int newDist=Math.max(dist,Math.abs(heights[newRow][newCol]-heights[row][col]));
25                    if(distance[newRow][newCol]>newDist){
26                        distance[newRow][newCol]=newDist;
27                        minheap.offer(new int[]{newDist,newRow,newCol});
28                    }
29                }
30            } 
31        }
32        return 0;
33    }
34}