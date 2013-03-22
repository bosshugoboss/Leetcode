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
