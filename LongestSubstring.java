public class Solution {
    public int lengthOfLongestSubstring(String s) {
           int maxLength = 0;
           int currentLength = 0;
           HashMap<Character, Integer> map = new HashMap<Character, Integer>();           
           for(int i = 0; i < s.length(); i++){
               if(map.containsKey(s.charAt(i))){
                  if(map.get(s.charAt(i)) < i - currentLength){
                    currentLength ++;
                  } 
                  else{
                    if(currentLength > maxLength) maxLength = currentLength;
                    currentLength = i - map.get(s.charAt(i));
                  }
                  map.put(s.charAt(i), i); 
               }
               else{
                   currentLength ++;
                   map.put(s.charAt(i), i);
               }
           }
           if(currentLength > maxLength) maxLength = currentLength;
           return maxLength;
    }
}
