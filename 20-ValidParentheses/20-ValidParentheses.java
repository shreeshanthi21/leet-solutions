// Last updated: 5/26/2026, 12:34:37 PM
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='('||c=='['||c=='{'){
                stack.push(c);
            }
            else{
                if(stack.isEmpty()) return false;
                char top=stack.pop();
                if(c==')' && top!='(') return false;
                if(c==']' && top!='[') return false;
                if(c=='}' && top!='{') return false;
            }
         }
         return stack.isEmpty();
    }
}