// Last updated: 5/29/2026, 8:32:05 PM
1import java.util.*;
2
3class Solution {
4    static class Pair {
5        long distOrWt;
6        int node;
7
8        Pair(long distOrWt, int node) {
9            this.distOrWt = distOrWt;
10            this.node = node;
11        }
12    }
13
14    public int countPaths(int n, int[][] roads) {
15        long MOD = 1_000_000_007L;
16        List<List<Pair>> graph = new ArrayList<>();
17        for (int i = 0; i < n; i++) {
18            graph.add(new ArrayList<>());
19        }
20        for (int[] road : roads) {
21            int u = road[0];
22            int v = road[1];
23            int wt = road[2];
24            graph.get(u).add(new Pair(wt, v));
25            graph.get(v).add(new Pair(wt, u));
26        }
27        long[] dist = new long[n];
28        long[] ways = new long[n];
29        Arrays.fill(dist, Long.MAX_VALUE);
30        
31        dist[0] = 0;
32        ways[0] = 1;
33        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingLong(p -> p.distOrWt));
34        pq.add(new Pair(0, 0));
35        while (!pq.isEmpty()) {
36            Pair current = pq.poll();
37            long d = current.distOrWt;
38            int node = current.node;
39            if (d > dist[node]) continue;
40            
41            for (Pair neighbor : graph.get(node)) {
42                int adjNode = neighbor.node;
43                long wt = neighbor.distOrWt;
44                long newDist = d + wt;
45                if (newDist < dist[adjNode]) {
46                    dist[adjNode] = newDist;
47                    ways[adjNode] = ways[node];
48                    pq.add(new Pair(newDist, adjNode));
49                } 
50                else if (newDist == dist[adjNode]) {
51                    ways[adjNode] = (ways[adjNode] + ways[node]) % MOD;
52                }
53            }
54        }
55        
56        return (int) (ways[n - 1] % MOD);
57    }
58}