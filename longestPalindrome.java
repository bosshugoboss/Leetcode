public class Solution {
    public String longestPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int max = 0;
        String tempString = "";
        for(int i = 0; i < s.length(); i++){
            int count1 = countCenter(s, i);
            int count2 = countLeft(s, i);
            int count = Math.max(count1, count2);
            if(count > max){
                if(count == count1){
                    int length = (count1 - 1)/2;
                    tempString = s.substring(i - length, i + length + 1);
                }
                else {
                    int length = count2/2;
                    tempString = s.substring(i - length + 1, i + length + 1); 
                }
                max = count;
            }
        }
        return tempString;
    }
    
    public int countCenter(String s, int i){
        int length = 1;
        while(i - length >= 0 && i + length < s.length()){
            if(s.charAt(i + length) != s.charAt(i - length)) break;
            length ++;
        }
        return 2*length - 1;
    }
    
    public int countLeft(String s, int i){
        int length = 0;
        while(i - length >= 0 && i + length + 1 < s.length()){
            if(s.charAt(i - length) != s.charAt(i + length + 1)) break;
            length ++;
        }
        return 2*length;
    }
}
