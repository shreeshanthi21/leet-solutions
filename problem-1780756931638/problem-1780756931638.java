// Last updated: 6/6/2026, 8:12:11 PM
1class Solution {
2    public long minEnergy(int n, int brightness, int[][] intervals) {
3        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
4        long active=0;
5        long start=intervals[0][0];
6        long end=intervals[0][1];
7        for(int i=0;i<intervals.length;i++){
8            long a=intervals[i][0];
9            long b=intervals[i][1];
10            if(a<=end+1){
11                end=Math.max(end,b);
12            }else{
13                active+=end-start+1;
14                start=a;
15                end=b;
16            }
17        }
18        active+=end-start+1;
19        long count=(brightness+2)/3;
20        return count*active;
21    }
22}