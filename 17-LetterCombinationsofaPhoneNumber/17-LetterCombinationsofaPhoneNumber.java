// Last updated: 6/17/2026, 10:31:53 AM
1class Solution {
2    // 8-element static array mapping '2'-'9' directly to their respective letters
3    private static final String[] MAP = {
4        "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
5    };
6
7    private void fun(String digits, int ptr, StringBuilder curr, List<String> res) {
8        // Base Case: Full combination formed
9        if(ptr == digits.length()) {
10            res.add(curr.toString()); 
11            return;
12        }
13        
14        int len = curr.length(); // 1. Track length state before modification
15        String poss = MAP[digits.charAt(ptr) - '2']; // Fast O(1) primitive map lookup
16        
17        // Primitive loop avoids structural iterator allocations
18        for(int i = 0; i < poss.length(); i++){
19            curr.append(poss.charAt(i));
20            
21            fun(digits, ptr + 1, curr, res); // Recurse to next digit position
22            
23            curr.setLength(len); // 2. Backtrack: Reset length to clear modifications
24        }
25    }
26    
27    public List<String> letterCombinations(String digits) {
28        List<String> res = new ArrayList<>();
29        if (digits == null || digits.length() == 0) return res; // Handle empty string edge case
30        
31        fun(digits, 0, new StringBuilder(), res);
32        return res;
33    }
34}