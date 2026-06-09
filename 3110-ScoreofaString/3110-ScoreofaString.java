// Last updated: 6/9/2026, 9:33:19 PM
1class Solution {
2    public int scoreOfString(String s) {
3        int ans =0;
4        for(int i =0;i<s.length()-1;i++){
5            char ch = s.charAt(i);
6            char chh = s.charAt(i+1);
7            int a = (int)ch;
8            int b = (int)chh;
9            ans += Math.abs(a-b);
10        }       
11        return ans;
12    }
13}