// Last updated: 6/3/2026, 7:13:08 PM
1class Solution {
2    public int minimumTotal(List<List<Integer>> triangle) {
3        // Start from the second-to-last row (triangle.size() - 2)
4        for (int i = triangle.size() - 2; i >= 0; i--) {
5            for (int j = 0; j < triangle.get(i).size(); j++) {
6                int below = triangle.get(i + 1).get(j);
7                int belowRight = triangle.get(i + 1).get(j + 1);
8                
9                // Update the current cell with the minimum path choice
10                int current = triangle.get(i).get(j);
11                triangle.get(i).set(j, current + Math.min(below, belowRight));
12            }
13        }
14        // The top of the triangle now holds the minimum total path sum
15        return triangle.get(0).get(0);
16    }
17}