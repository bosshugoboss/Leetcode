/**
 * 
 * Implement regular expression matching with support for '.' and '*'.
 * 
 */
public class Solution {
    public boolean isMatch(String s, String p) {
         if(s.length() == 0){   
           if(p.length()>= 2 && p.charAt(1) =='*')
           return isMatch(s, p.substring(2,p.length()));
           return p.length() == 0;
         }    
         if(p.length() == 0) return false;
         if(p.length() == 1){
            if(s.length() == 1){
              if(p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'){
                return true;                  
              }           
            }
            return false;
         }
         if(p.charAt(1) != '*'){            
            if(p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'){
              return isMatch(s.substring(1,s.length()), p.substring(1,p.length()));
            } 
            else{
              return false;
            }
         }
         else{
             while(s.length() > 0 && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0))){
              if(isMatch(s,p.substring(2,p.length()))) return true;
              s = s.substring(1,s.length());
            }
         }
         return isMatch(s, p.substring(2,p.length()));
    }
}
