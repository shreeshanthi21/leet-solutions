// Last updated: 5/26/2026, 12:34:25 PM
class Solution {
    public int strStr(String haystack, String needle) {
        
        int right=needle.length();
        if(haystack.length()<needle.length()) return -1;
        for(int i=0;i<=haystack.length()-right;i++){
            StringBuilder temp=new StringBuilder();
            for(int j=i;j<i+right;j++){
                temp.append(haystack.charAt(j));
                if(temp.toString().equals(needle)) return i;
            }
        }
        return -1;

    }
}