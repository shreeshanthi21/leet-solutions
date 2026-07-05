// Last updated: 7/5/2026, 9:05:38 AM
1class Solution {
2    public int divisibleGame(int[] nums) {
3        int n = nums.length;
4        long mod = 1_000_000_007L;
5        
6        int mxv = 2;
7        for (int x : nums) {
8            if (x > mxv) mxv = x;
9        }
10        
11        HashSet<Integer> ks = new HashSet<>();
12        ks.add(2); 
13        ks.add(mxv + 1); 
14        
15        for (int x : nums) {
16            if (x <= 1) continue;
17            for (int d = 1; d * d <= x; d++) {
18                if (x % d == 0) {
19                    if (d > 1) ks.add(d);
20                    if (x / d > 1) ks.add(x / d);
21                }
22            }
23        }
24        
25        int[] r = nums;
26        long bd = Long.MIN_VALUE;
27        int bk = 2;
28        
29        for (int k : ks) {
30            long p = 0;
31            long mp = 0;
32            long cb = Long.MIN_VALUE;
33            
34            for (int i = 0; i < n; i++) {
35                int v = (r[i] % k == 0) ? r[i] : -r[i];
36                p += v;
37                if (p - mp > cb) {
38                    cb = p - mp;
39                }
40                if (p < mp) {
41                    mp = p;
42                }
43            }
44            
45            if (cb > bd || (cb == bd && k < bk)) {
46                bd = cb;
47                bk = k;
48            }
49        }
50        
51        long ans = (bd % mod);
52        ans = (ans * (bk % mod)) % mod;
53        ans = (ans + mod) % mod;
54        
55        return (int) ans;
56    }
57}