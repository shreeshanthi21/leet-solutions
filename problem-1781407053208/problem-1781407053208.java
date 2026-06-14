// Last updated: 6/14/2026, 8:47:33 AM
1class Solution {
2    public int getLength(int[] nums) {
3        int n=nums.length;
4        int res=1;
5        for(int i=0;i<n;i++){
6            HashMap<Integer,Integer> freq=new HashMap<>();
7            TreeMap<Integer,Integer> hm=new TreeMap<>();
8            for(int j=i;j<n;j++){
9                int x=nums[j];
10                int len=j-i+1;
11                int old = freq.getOrDefault(x, 0); 
12                if(old>0){
13                    hm.merge(old, -1, Integer::sum);
14                    if (hm.get(old) == 0) hm.remove(old);
15                }
16                freq.merge(x,1,Integer::sum);
17                int newf=freq.get(x);
18                hm.merge(newf, 1, Integer::sum);
19                if(hm.size()==1){
20                    if (freq.size() == 1) {
21                        res = Math.max(res, len);
22                    }
23                }
24                else if(hm.size()==2){
25                     int small = hm.firstKey();
26                     int large = hm.lastKey();
27                     if (large == 2 * small) {
28                       res = Math.max(res, len);
29                     }
30                }
31            }
32        }
33        return res;
34    }
35}