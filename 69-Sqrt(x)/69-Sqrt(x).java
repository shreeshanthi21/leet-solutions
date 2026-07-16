// Last updated: 7/16/2026, 8:53:39 PM
1class Solution {
2    public int mySqrt(int x) {
3        if (x == 0 || x == 1)
4            return x;
5        int start = 1;
6        int end = x;
7        int mid = -1;
8        while (start <= end) {
9            mid = start + (end - start) / 2;
10            if ((long) mid * mid > (long) x)
11                end = mid - 1;
12            else if (mid * mid == x)
13                return mid;
14            else
15                start = mid + 1;
16        }
17
18        
19        return Math.round(end);
20    }
21}