// Last updated: 7/7/2026, 4:32:52 PM
1class Solution {
2    public char kthCharacter(int k) {
3        String word="a";
4        while(word.length()<k){
5            String next="";
6            for(int i=0;i<word.length();i++){
7                char ch=word.charAt(i);
8                if(ch=='z') next+='a';
9                else next+=(char)(ch+1);
10            }
11            word+=next;
12        }
13        return word.charAt(k-1);
14    }
15}