// Last updated: 7/2/2026, 8:10:31 AM
1class Solution {
2    public int[] intersection(int[] nums1, int[] nums2) {
3        HashSet<Integer> set = new HashSet<>();
4        HashSet<Integer> intersectionSet = new HashSet<>();
5        
6        for (int i : nums1) {
7            set.add(i);
8        }
9        
10        for (int i : nums2) {
11            if (set.contains(i)) {
12                intersectionSet.add(i); // Duplicates are ignored automatically
13            }
14        }
15        
16        // Convert HashSet to int[]
17        int[] result = new int[intersectionSet.size()];
18        int index = 0;
19        for (int num : intersectionSet) {
20            result[index++] = num;
21        }
22        
23        return result;
24    }
25}