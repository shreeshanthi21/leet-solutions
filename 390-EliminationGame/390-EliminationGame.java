// Last updated: 7/6/2026, 10:25:44 PM
1class Solution {
2    public int lastRemaining(int n) {
3        int step = 0;
4        int sum = 0;
5
6        while (true) {
7            if (n == 1) break;
8
9            if (step % 2 == 1 && n % 2 == 0) {
10                sum += (1 << step);
11            }
12
13            n /= 2;
14            step++;
15        }
16
17        return (1 << step) - sum;
18    }
19}