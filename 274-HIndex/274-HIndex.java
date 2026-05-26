// Last updated: 5/26/2026, 12:31:54 PM
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] temp = new int[n + 1];

        for (int v : citations) {
            if (v > n) {
                temp[n]++;
            } else {
                temp[v]++;
            }
        }

        int total = 0;

        for (int i = n; i >= 0; i--) {
            total += temp[i];

            if (total >= i) {
                return i;
            }
        }

        return 0;
    }
}