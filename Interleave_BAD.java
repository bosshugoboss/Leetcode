
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
           if(s2.length() == 0) return s3.equals(s1);
           if(s1.length() == 0) return s3.equals(s2);
           return isInterleaveHelper(s1, 0, s2, 0, s3, 0);
  }

    public boolean isInterleaveHelper(String s1, int i1, String s2, int i2, String s3, int i3) {
    
           if(i3 == s3.length()){
           	   if(i1 == s1.length()  && i2 == s2.length()) return true;
           	   else return false;
           } 
           else{
           	   if(i1 != s1.length()  && s1.charAt(i1) == s3.charAt(i3)){
           	   	  if(i2 != s2.length()  && s2.charAt(i2) == s3.charAt(i3)) {
           	   	  	 return isInterleaveHelper(s1, i1 + 1, s2, i2, s3, i3 + 1)
           	   	  	     || isInterleaveHelper(s1, i1, s2, i2 + 1, s3, i3 + 1);
           	   	  }
           	   	  else{
           	   	  	  return isInterleaveHelper(s1, i1 + 1, s2, i2, s3, i3 + 1);
           	   	  }
           	   }

           	   else if(i2 != s2.length() && s2.charAt(i2) == s3.charAt(i3)){
           	   	  return isInterleaveHelper(s1, i1, s2, i2 + 1, s3, i3 + 1);
           	   } 

           	   return false;
           }

    }

}
