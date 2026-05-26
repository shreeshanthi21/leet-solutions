// Last updated: 5/26/2026, 12:33:52 PM
class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim(); // remove leading/trailing spaces
        int cnt = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                return cnt;
            }
            cnt++;
        }
        return cnt;
    }
}