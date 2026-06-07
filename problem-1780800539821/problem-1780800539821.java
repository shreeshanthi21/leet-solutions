// Last updated: 6/7/2026, 8:18:59 AM
1class Solution {
2    List<String> res=new ArrayList<>();
3    public List<String> generateValidStrings(int n, int k) {
4        StringBuilder s=new StringBuilder();
5        helper(0,n,k,0,s);
6        return res;
7    }
8    public void helper(int idx,int n,int k,int cost,StringBuilder s){
9        if(idx==n){
10            res.add(s.toString());
11            return;
12        }
13        s.append('0');
14        helper(idx+1,n,k,cost,s);
15        s.deleteCharAt(s.length()-1);
16        if((s.isEmpty() || s.charAt(s.length()-1)!='1') && cost+idx<=k){
17            s.append('1');
18            helper(idx+1,n,k,cost+idx,s);
19            s.deleteCharAt(s.length()-1);
20        }    
21    }
22}