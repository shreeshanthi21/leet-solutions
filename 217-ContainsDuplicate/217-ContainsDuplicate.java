// Last updated: 6/4/2026, 10:23:07 PM
1class Solution {
2    public boolean containsDuplicate(int[] nums) {
3        HashMap<Integer,Integer> hm=new HashMap<>();
4        for(int num:nums){
5            hm.put(num,hm.getOrDefault(num,0)+1);
6        }
7        for(int num:hm.keySet()){
8            if(hm.get(num)>=2) return true;
9        }
10        return false;
11    }
12}