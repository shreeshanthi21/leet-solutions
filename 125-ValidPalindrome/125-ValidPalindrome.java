// Last updated: 5/26/2026, 12:32:57 PM
class Solution {
    public boolean isPalindrome(String str) {
        String s = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left=0;
        int right=s.length()-1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            right--;left++;
        }
        return true;
    }
}