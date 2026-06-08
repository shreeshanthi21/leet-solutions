// Last updated: 6/8/2026, 9:54:46 PM
1class Solution {
2    public int scoreOfString(String s) {
3        HashMap<Character,Integer> hm=new HashMap<>();
4        int ascii;
5        for(char ch:s.toCharArray()){
6            ascii=ch;
7            hm.put(ch,ascii);
8        }
9        int sum=0;
10        char[] arr=s.toCharArray();
11        for(int i=0;i<arr.length-1;i++){
12            sum+=Math.abs(hm.get(arr[i])-hm.get(arr[i+1]));
13        }        
14        return sum;
15    }
16}