


public class Solution {

    public boolean isInterleave(String s1, String s2, String s3) {

         if(s3.length() != s2.length() + s1.length()) return false;
         boolean[][] result = new boolean[s1.length() + 1][s2.length() + 1];
  	 result[0][0] = true;
		 for(int i1 = 1; i1 <= s1.length(); i1 ++) {
             if(s1.charAt(i1 - 1) == s3.charAt(i1 + 0 - 1)){
             	result[i1][0] = result[i1 - 1][0] && true;
             }
             else{
             	result[i1][0] = false;
             }
		 }
		 for(int i2 = 1 ;i2 <= s2.length(); i2 ++) {
		 	 if(s2.charAt(i2 - 1) == s3.charAt(i2 + 0 - 1)) {
		 	 	result[0][i2] = result[0][i2 - 1] && true;
		 	 }
		 	 else{
		 	 	result[0][i2] = false;
		 	 }
		 }
		 for(int i1 = 1; i1 <= s1.length() ; i1 ++) {
		 	 for(int i2 = 1 ; i2 <= s2.length(); i2 ++) { 
                 if(s2.charAt(i2 - 1) == s3.charAt(i1 + i2 - 1)){
                 	result[i1][i2] = result[i1][i2] || (true && result[i1][i2 - 1]);
                 }
                 if(s1.charAt(i1 - 1) == s3.charAt(i1 + i2 - 1)){
                 	result[i1][i2] = result[i1][i2] || (true && result[i1 - 1][i2]);
                 }
		 	 }
		 }
		 return result[s1.length()][s2.length()];
	}
}


