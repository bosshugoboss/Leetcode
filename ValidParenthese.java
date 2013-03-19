/**
 * Given a string containing just the characters '(', ')', 
 * '{', '}', '[' and ']', determine if the input string 
 * is valid.The brackets must close in the correct order, "()" and 
 * "()[]{}" are all valid but "(]" and "([)]" are not.
 */ 
 
public class Solution {
    public boolean isValid(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Stack<Character> stack = new Stack<Character>();
        for(int index = 0; index < s.length(); index ++){
            if(isLeft(s.charAt(index)))
               stack.push(s.charAt(index));
            else{
               if(stack.isEmpty()) return false;
               char first = stack.pop();
               if(!isPair(first,s.charAt(index)))
               return false;
            }
        
        }
        if(stack.isEmpty()) return true;
        return false;
    }
    
    public boolean isLeft(char ch){
        return ch == '{' || ch == '[' || ch == '(' ;
    }
    
    public boolean isPair(char first, char second){
        return (first == '(' && second == ')') || (first == '{' && second == '}') 
               || (first == '[' && second == ']');
    }
}
