// Last updated: 5/28/2026, 11:57:15 PM
1class Solution {
2        public int shortestPathBinaryMatrix(int[][] grid) {
3        if (grid == null || grid.length == 0 || grid[0].length == 0) {
4            return -1;
5        }
6
7        int ans = 0;
8
9        int row = grid.length;
10        int col = grid[0].length;
11
12        if (grid[0][0] == 1 || grid[row - 1][col - 1] == 1) {
13            return -1;
14        }
15
16        int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
17
18        boolean[][] visited = new boolean[row][col];
19
20        Queue<int[]> queue = new LinkedList<>();
21        queue.offer(new int[]{0, 0});
22        visited[0][0] = true;
23
24        while (!queue.isEmpty()) {
25            int size = queue.size();
26            ans++;
27
28            for (int i = 0; i < size; i++) {
29                int[] curPos = queue.poll();
30
31                if (curPos[0] == row - 1 && curPos[1] == col - 1) {
32                    return ans;
33                }
34
35                for (int[] dir : dirs) {
36                    int nextX = curPos[0] + dir[0];
37                    int nextY = curPos[1] + dir[1];
38
39                    if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col || visited[nextX][nextY] || grid[nextX][nextY] == 1) {
40                        continue;
41                    }
42
43                    visited[nextX][nextY] = true;
44                    queue.offer(new int[]{nextX, nextY});
45                }
46            }
47        }
48
49        return -1;
50    }
51}