// Last updated: 5/29/2026, 12:19:45 AM
1class Solution {
2        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
3        HashMap<Integer,List<int[]>> map = new HashMap<>();
4        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[1]-b[1]);
5        for(int i = 0 ; i < n ; i++){
6            map.put(i, new ArrayList<>());
7        }
8        for(int[] a: flights){
9            map.get(a[0]).add(new int[]{a[1], a[2]});
10        }
11        q.add(new int[]{src,0,-1});
12        int[] stops = new int[n];
13        Arrays.fill(stops,Integer.MAX_VALUE);
14        while(!q.isEmpty()){
15            int[] b = q.poll();
16            int st = b[0];
17            int dist = b[1];
18            if(st == dst) return dist;
19            if(b[2] >= k || stops[st] <= b[2]) continue;
20            stops[st] = b[2];
21            for(int[] c : map.get(st)){
22                int newdist = c[1] + dist;
23                q.add(new int[]{c[0], newdist,b[2]+1});                             
24            }
25        }
26        return -1;
27    }
28}
29