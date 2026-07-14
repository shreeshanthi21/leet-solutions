// Last updated: 7/14/2026, 7:45:07 AM
1class Solution {
2    public int minDistance(String word1, String word2) {
3            final int m = word1.length();//first word length
4    final int n = word2.length();///second word length
5    // dp[i][j] := min # of operations to convert word1[0..i) to word2[0..j)
6    int[][] dp = new int[m + 1][n + 1];
7
8    for (int i = 1; i <= m; ++i)
9      dp[i][0] = i;
10
11    for (int j = 1; j <= n; ++j)
12      dp[0][j] = j;
13
14    for (int i = 1; i <= m; ++i)
15      for (int j = 1; j <= n; ++j)
16        if (word1.charAt(i - 1) == word2.charAt(j - 1))//same characters
17          dp[i][j] = dp[i - 1][j - 1];//no operation
18        else
19          dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;                      //replace               //delete        //insert
20
21    return dp[m][n];
22  }
23}