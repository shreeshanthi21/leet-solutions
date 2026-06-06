// Last updated: 6/6/2026, 8:28:11 PM
1class Solution {
2    public long maxTotal(int[] nums, String s) {
3        int n=nums.length;
4        long result=0;
5        for(int i=0;i<n;){
6            if(s.charAt(i)=='0'){
7                i++; continue;
8            }
9            int begin=i;
10            long sum=0;
11            int mini=Integer.MAX_VALUE;
12         
13            
14            if(begin>0){
15                sum+=nums[begin-1];
16                mini=Math.min(mini,nums[begin-1]);
17            }
18            while(i<n && s.charAt(i)=='1'){
19                sum+=nums[i];
20                mini=Math.min(mini,nums[i]);
21                i++;
22            }
23            if(begin==0) result+=sum;
24            else result+=sum-mini;
25        }
26        return result;
27    }
28}