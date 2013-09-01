public class Solution {
    public boolean isPalindrome(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(x < 0) return false;
        String s = x >= 0 ? String.valueOf(x) : String.valueOf(-x);
        int length = s.length() - 1;
        for(int i = 0; i <= length / 2; i++){
            if(s.charAt(i) != s.charAt(length - i)) return false;
        }
        return true;
    }
}
