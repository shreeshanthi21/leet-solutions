// Last updated: 6/30/2026, 12:20:53 PM
1class Solution {
2    public int findContentChildren(int[] g, int[] s) {
3        Arrays.sort(s);
4        Arrays.sort(g);
5        int left=0,right=0;
6        while(left<s.length && right<g.length){
7            if(s[left]>=g[right]){
8                right++;
9            }
10            left++;
11        }
12        return right;
13    }
14}