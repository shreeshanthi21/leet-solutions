// Last updated: 7/15/2026, 7:51:34 AM
1import java.util.ArrayList;
2import java.util.List;
3
4class Solution {
5    private int n;
6
7    private boolean isPalindrome(String s, int l, int r) {
8        while (r > l) {
9            if (s.charAt(l) != s.charAt(r)) {
10                return false;
11            }
12            l++;
13            r--;
14        }
15        return true;
16    }
17
18    private void backtrack(String s, int idx, List<String> curr, List<List<String>> ans) {
19        if (idx == n) {
20            // In Java, we must make a deep copy of the list because lists are passed by reference
21            ans.add(new ArrayList<>(curr));
22            return;
23        }
24        for (int i = idx; i < n; i++) {
25            if (isPalindrome(s, idx, i)) {
26                curr.add(s.substring(idx, i + 1)); // i + 1 because substring end index is exclusive
27                backtrack(s, i + 1, curr, ans);
28                curr.remove(curr.size() - 1); // Backtrack step
29            }
30        }
31    }
32
33    public List<List<String>> partition(String s) {
34        n = s.length();
35        List<String> curr = new ArrayList<>();
36        List<List<String>> ans = new ArrayList<>();
37        backtrack(s, 0, curr, ans);
38        return ans;
39    }
40}