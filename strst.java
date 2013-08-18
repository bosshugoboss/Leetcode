public class Solution {
    public String strStr(String haystack, String needle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(haystack == null || needle == null) return null;
        int hayStart = 0;        
        if(haystack.length() < needle.length()) return null;
        while(hayStart <= haystack.length() && 
              haystack.length() - hayStart >= needle.length()){
              int subStart = hayStart;
              int needStart = 0;
              for(; needStart < needle.length(); needStart ++){
                  if(haystack.charAt(needStart + subStart) != needle.charAt(needStart))
                    break;
              } 
              if(needStart == needle.length()) return haystack.substring(subStart);
              hayStart ++;
        }
        return null;
    }
}
