// Last updated: 6/25/2026, 11:39:14 PM
1class Solution {
2    public boolean checkGoodInteger(int n) {
3        int temp1=n;
4        int temp2=n;
5        int digisum=0;
6        int sqsum=0;
7        while(temp1!=0){
8            int rem=temp1%10;
9            digisum+=rem;
10            temp1/=10;
11        }
12        while(temp2!=0){
13            int rem=temp2%10;
14            sqsum+=rem*rem;
15            temp2/=10;
16        }
17        if(sqsum-digisum>=50) return true;
18        return false;
19    }
20}