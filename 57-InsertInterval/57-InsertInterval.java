// Last updated: 5/29/2026, 1:08:43 AM
1class Solution {
2    public int[][] insert(int[][] intervals, int[] newInterval) {
3        List<int[]> result=new ArrayList<>();
4        int newStart=newInterval[0];
5        int newEnd=newInterval[1];
6        int n=intervals.length;
7        int i=0;
8        while(i<n && intervals[i][1] <newStart){
9            result.add(intervals[i]);
10            i++;
11        }
12        while(i<n && newEnd>=intervals[i][0]){
13            newStart=Math.min(newStart,intervals[i][0]);
14            newEnd=Math.max(newEnd,intervals[i][1]);
15            i++;
16        }
17        result.add(new int[]{newStart,newEnd});
18        while(i<n){
19            result.add(intervals[i]);
20            i++;
21        }
22        return result.toArray(new int[result.size()][]);
23    }
24}