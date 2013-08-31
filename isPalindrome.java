public class Solution {
    public boolean isPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        s= s.toLowerCase();
        s= s.replaceAll("[^a-z0-9]","");
        if(s.length() == 0) return true;
        int halfLength = (s.length() - 1)/2;
        for(int i = 0; i <= halfLength; i++){
        	if(s.charAt(i) != s.charAt(s.length() - 1 - i))
        		return false;
        }
        return true;
    }
}
