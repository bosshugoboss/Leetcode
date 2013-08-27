public class Solution {
    public int minDistance(String word1, String word2) {
           int length1 = word1.length();
           int length2 = word2.length();
           int[][] resultset = new int[length1+1][length2+1];
	       for(int i = 0 ; i <= length1; i ++){
	             resultset[i][0] = i;
	       }
	       for(int i = 0 ; i <= length2; i ++){
	             resultset[0][i] = i;
 	       }
	    for(int i = 1 ; i <= length1; i ++){
	      for(int j = 1; j <= length2; j ++){
		    if(word1.charAt(i - 1) == word2.charAt(j - 1))	
                resultset[i][j] = resultset[i-1][j-1];
           else
            resultset[i][j] = 1 + Math.min(resultset[i-1][j-1], Math.min(resultset[i][j-1], resultset[i-1][j]));
	       }   
	    }
          return resultset[length1][length2];
    }
}
