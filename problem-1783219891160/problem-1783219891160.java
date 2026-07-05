// Last updated: 7/5/2026, 8:21:31 AM
1class Solution {
2    public int maxDigitRange(int[] nums) {
3        HashMap<Integer, Integer> hm = new HashMap<>();
4        int maxRange = Integer.MIN_VALUE;
5        
6        for (int i : nums) {
7            long temp = Math.abs((long) i);
8            int mx = Integer.MIN_VALUE;
9            int mn = Integer.MAX_VALUE;
10            if (temp == 0) {
11                mx = 0;
12                mn = 0;
13            }
14            while (temp > 0) {
15                int r = (int) temp % 10;
16                mx = Math.max(mx, r);
17                mn = Math.min(mn, r);
18                temp = temp / 10;
19            }
20            int dig_range = mx - mn;
21            hm.put(dig_range, hm.getOrDefault(dig_range, 0) + i);
22            maxRange = Math.max(maxRange, dig_range);
23        }
24        
25        return maxRange == Integer.MIN_VALUE ? 0 : hm.get(maxRange);
26    }
27}