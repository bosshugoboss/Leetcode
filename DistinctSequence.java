public class Solution {
    public int numDistinct(String S, String T) {
           if(S.length() < T.length()) return 0;
           int[] result = new int[T.length() + 1];
           result[0] = 1; 
           for(int i = 0; i <= S.length() - 1; i ++){
                  for(int j = T.length() - 1; j >= 0 ; j--) {
                	   if(S.charAt(i) == T.charAt(j)){
           	   	       result[j + 1] += result[j];
           	   	   }
           	   }
           }
           return result[T.length()];
    }
}	
