// Last updated: 5/29/2026, 12:07:40 AM
1import java.util.*;
2
3class Solution {
4    class Pair {
5        int v;
6        int weight;
7        Pair(int v, int weight) {
8            this.v = v;
9            this.weight = weight;
10        }
11    }
12
13    public int networkDelayTime(int[][] times, int n, int k) {
14        List<List<Pair>> adj = new ArrayList<>();
15        for (int i = 0; i <= n; i++) {
16            adj.add(new ArrayList<>());
17        }
18        int M = times.length;
19        for (int i = 0; i < M; i++) {
20            int u = times[i][0];
21            int v = times[i][1];
22            int wt = times[i][2];
23            adj.get(u).add(new Pair(v, wt));
24        }
25        int[] distance = new int[n + 1];
26        Arrays.fill(distance, Integer.MAX_VALUE);
27        distance[k] = 0; 
28        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
29        pq.add(new Pair(k, 0));
30
31        while (!pq.isEmpty()) {
32            Pair current = pq.poll();
33            int node = current.v;
34            int currentDist = current.weight;
35            if (currentDist > distance[node]) continue;
36
37            for (Pair neighbor : adj.get(node)) {
38                int v = neighbor.v;
39                int wt = neighbor.weight;
40                if (distance[node] + wt < distance[v]) {
41                    distance[v] = distance[node] + wt;
42                    pq.add(new Pair(v, distance[v]));
43                }
44            }
45        }
46        int maxTime = 0;
47        for (int i = 1; i <= n; i++) {
48            if (distance[i] == Integer.MAX_VALUE) {
49                return -1; 
50            }
51            maxTime = Math.max(maxTime, distance[i]);
52        }
53        return maxTime;
54    }
55}