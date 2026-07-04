// Last updated: 7/4/2026, 8:28:17 PM
1class Solution {
2    public int minOperations(String s1, String s2) {
3        int n=s1.length();
4        if(n==1){
5            if(s1.equals(s2)) return 0;
6            return s1.charAt(0)=='1'?-1:1;
7        }
8        int res=0;
9        int i=0;
10        while(i<n){
11            char a=s1.charAt(i),b=s2.charAt(i);
12            if(a=='0' && b=='1'){
13                res++;
14                i++;
15            }else if(a=='1' && b=='0'){
16                int j=i;
17                while(j<n && s1.charAt(j)=='1' && s2.charAt(j)=='0') j++;
18                int L=j-i;
19                res+=L/2+(L%2)*2;
20                i=j;
21            }else{
22                i++;
23            }
24        }
25        return res;
26    }
27}