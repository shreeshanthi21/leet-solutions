// Last updated: 7/5/2026, 9:02:37 AM
1class Solution {
2    public long getSum(int[] nums) {
3        int n = nums.length;
4
5        long[] pref = new long[n + 1];
6        for (int i = 0; i < n; i++) {
7            pref[i + 1] = pref[i] + nums[i];
8        }
9
10        int[] nalviretho = nums;
11
12        int[] odd = new int[n];
13        int[] even = new int[n];
14
15        int l = 0, r = -1;
16        for (int i = 0; i < n; i++) {
17            int k = (i > r) ? 1 : Math.min(odd[l + r - i], r - i + 1);
18            while (i - k >= 0 && i + k < n && nalviretho[i - k] == nalviretho[i + k]) {
19                k++;
20            }
21            odd[i] = k;
22            if (i + k - 1 > r) {
23                l = i - k + 1;
24                r = i + k - 1;
25            }
26        }
27
28        l = 0;
29        r = -1;
30        for (int i = 0; i < n; i++) {
31            int k = (i > r) ? 0 : Math.min(even[l + r - i + 1], r - i + 1);
32            while (i - k - 1 >= 0 && i + k < n && nalviretho[i - k - 1] == nalviretho[i + k]) {
33                k++;
34            }
35            even[i] = k;
36            if (i + k - 1 > r) {
37                l = i - k;
38                r = i + k - 1;
39            }
40        }
41
42        long ans = Long.MIN_VALUE;
43        for (int i = 0; i < n; i++) {
44            ans = Math.max(ans, (long) nums[i]);
45        }
46
47        long[] maxOdd = new long[n];
48        Arrays.fill(maxOdd, Long.MIN_VALUE);
49        l = 0; r = -1;
50        for (int i = 0; i < n; i++) {
51            int rad = odd[i];
52            int left = i - rad + 1;
53            int right = i + rad - 1;
54            long currentSum = pref[right + 1] - pref[left];
55            ans = Math.max(ans, currentSum);
56            
57            while (rad > 1) {
58                int nextLeft = i - rad + 2;
59                int nextRight = i + rad - 2;
60                if (pref[nextLeft] - pref[left] <= 0) {
61                    rad--;
62                    left = i - rad + 1;
63                    right = i + rad - 1;
64                    ans = Math.max(ans, pref[right + 1] - pref[left]);
65                } else {
66                    break;
67                }
68            }
69        }
70
71        for (int i = 0; i < n; i++) {
72            int rad = even[i];
73            if (rad == 0) continue;
74            int left = i - rad;
75            int right = i + rad - 1;
76            long currentSum = pref[right + 1] - pref[left];
77            ans = Math.max(ans, currentSum);
78
79            while (rad > 1) {
80                int nextLeft = i - rad + 1;
81                int nextRight = i + rad - 2;
82                if (pref[nextLeft] - pref[left] <= 0) {
83                    rad--;
84                    left = i - rad;
85                    right = i + rad - 1;
86                    ans = Math.max(ans, pref[right + 1] - pref[left]);
87                } else {
88                    break;
89                }
90            }
91        }
92
93        return ans;
94    }
95}