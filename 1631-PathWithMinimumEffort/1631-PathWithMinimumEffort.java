// Last updated: 5/29/2026, 7:11:14 PM
1class Solution {
2    int[] dirR=new int[] {-1,0,+1,0};
3    int[] dirC=new int[] {0,+1,0,-1};
4    public int minimumEffortPath(int[][] heights) {
5        int m=heights.length;
6        int n=heights[0].length;
7        int[][] distance=new int[m][n];
8        for(int i=0;i<m;i++) Arrays.fill(distance[i],Integer.MAX_VALUE);
9        distance[0][0]=0;
10        PriorityQueue<int[]> minheap=new PriorityQueue<>(
11            Comparator.comparingInt(a->a[0])
12        );
13        minheap.offer(new int[]{0,0,0});
14        while(!minheap.isEmpty()){
15            int[] curr=minheap.poll();
16            int dist=curr[0];
17            int row=curr[1];
18            int col=curr[2];
19            if(dist>distance[row][col]) continue;
20            if(row==m-1 && col==n-1) return dist;
21            for(int i=0;i<4;i++){
22                int newRow=row+dirR[i];
23                int newCol=col+dirC[i];
24                if(newRow>=0 && newRow<m && newCol>=0 && newCol<n){
25                    int newDist=Math.max(dist,Math.abs(heights[newRow][newCol]-heights[row][col]));
26                    if(distance[newRow][newCol]>newDist){
27                        distance[newRow][newCol]=newDist;
28                        minheap.offer(new int[]{newDist,newRow,newCol});
29                    }
30                }
31            } 
32        }
33        return 0;
34    }
35}