// Last updated: 6/8/2026, 9:55:13 PM
class Solution {
    public int scoreOfString(String s) {
        int ans =0;
        for(int i =0;i<s.length()-1;i++){
            char ch = s.charAt(i);
            char chh = s.charAt(i+1);
            int a = (int)ch;
            int b = (int)chh;
            ans += Math.abs(a-b);
        }       
        return ans;
    }
}