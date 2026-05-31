// Last updated: 5/31/2026, 8:05:13 AM
1class Solution {
2    public int digitFrequencyScore(int n) {
3        HashMap<Integer,Integer> hm=new HashMap<>();
4        int temp=n;
5        while(temp!=0){
6            int rem=temp%10;
7            hm.put(rem,hm.getOrDefault(rem,0)+1);
8            temp/=10;
9        }
10        int sum=0;
11        for(int i:hm.keySet()){
12            sum+=i*hm.get(i);
13        }
14        return sum;
15    }
16}