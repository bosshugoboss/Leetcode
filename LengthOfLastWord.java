public class Solution {
    public int lengthOfLastWord(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int count = 0;
        boolean wordStart = false;
        for(int index = s.length() - 1; index >= 0; index --){
            if(!wordStart){
                if(s.charAt(index) != ' ') {
                  wordStart = true;
                  count = 1;                
                }           
            }
            else{
                if(s.charAt(index) != ' ') count ++;
                else break;
            }               
        }
        return count;
    }
}

/* new */
public class Solution {
    public int lengthOfLastWord(String s) {
        int lastIndex = -1;
        int lastLength = 0;
        for(int i = 0 ; i <= s.length(); i ++){
            if(i == s.length() || s.charAt(i) == ' '){
                lastLength = i - lastIndex - 1 == 0? lastLength : i - lastIndex - 1;
                lastIndex = i;
            }
        }
        return lastLength;
    }
}
