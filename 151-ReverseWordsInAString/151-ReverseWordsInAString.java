// Last updated: 5/26/2026, 12:32:31 PM
class Solution {
    public String reverseWords(String s) {
        // Step 1: Trim and split by spaces
        String[] words = s.trim().split("\\s+");
        
        // Step 2: Reverse the array
        int left = 0, right = words.length - 1;
        while (left < right) {
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }
        
        // Step 3: Join with single space
        return String.join(" ", words);
    }
}