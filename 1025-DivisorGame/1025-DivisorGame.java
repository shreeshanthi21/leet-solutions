// Last updated: 7/14/2026, 10:03:38 PM
1  class Solution {
2   public boolean divisorGame(int N) {           
3
4        boolean[] cache = new boolean[N+1];
5        if (N== 1){
6            cache[1] = false;
7            return false;
8        }
9       
10        if (N== 2){
11            cache[2] = true;
12            return true;
13        }
14       
15        for (int i=1;i*i<=N;i++){
16            if (N % i == 0){
17                cache[i] = !(divisorGame(N-i));
18                return cache[i];
19            }
20        }
21        return false;
22    }   
23 }