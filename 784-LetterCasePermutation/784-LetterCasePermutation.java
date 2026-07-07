// Last updated: 7/7/2026, 4:20:54 PM
1class Solution {
2    List<String> res=new ArrayList<>();
3    public void solve(String ip,String op){
4        if(ip.length()==0){
5            res.add(op);
6            return;
7        }
8        String op1=op;
9        String op2=op;
10        op2+=ip.charAt(0);
11        if(Character.isUpperCase(ip.charAt(0))){
12            op1+=Character.toLowerCase(ip.charAt(0));
13        }
14        else if(Character.isLowerCase(ip.charAt(0))){
15            op1+=Character.toUpperCase(ip.charAt(0));
16        }
17        else{
18            op1+=ip.charAt(0); 
19        }
20        ip=ip.substring(1);
21        solve(ip,op1);
22        if (Character.isLetter(op2.charAt(op2.length() - 1))) {
23            solve(ip,op2);
24        }
25    }
26    public List<String> letterCasePermutation(String s) {
27        String op="";
28        solve(s,op);
29        return res;
30    }
31}