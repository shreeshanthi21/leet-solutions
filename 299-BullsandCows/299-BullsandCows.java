// Last updated: 6/11/2026, 10:08:14 PM
1class Solution {
2    public String getHint(String secret, String guess) {
3        int bulls = 0;
4        int cows = 0;
5        int[] numbers = new int[10];
6        for (int i = 0; i<secret.length(); i++) {
7            if (secret.charAt(i) == guess.charAt(i)) bulls++;
8            else {
9                if (numbers[secret.charAt(i)-'0']++ < 0) cows++;
10                if (numbers[guess.charAt(i)-'0']-- > 0) cows++;
11            }
12        }
13        return bulls + "A" + cows + "B";
14    }
15}