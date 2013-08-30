public class Solution {
      public int minCut(String s){

        boolean[][] isPal = new boolean[s.length()][s.length()];
        int[] result = new int[s.length() + 1];
	    for(int i = 0; i < s.length(); i++){
	        isPal[i][i] = true;
	        if(i > 0) isPal[i-1][i] = s.charAt(i-1) == s.charAt(i);
	    }
	    for(int i = 2; i < s.length(); i++){
	        for(int j = i - 2; j >= 0; j--){
	            isPal[j][i] = s.charAt(j) == s.charAt(i) && isPal[j+1][i-1];
	        } 
	    }
	    result[s.length()] = 0;
	    for(int i = s.length() - 1; i >= 0; i--){
	        for(int j = i; j < s.length(); j++){
	            if(isPal[i][j]){
	              if(result[i] == 0) result[i] = 1 + result[j + 1];
	              else result[i] = Math.min(result[i], 1 + result[j + 1]);
	            }
	        }
	    }
	    return result[0] - 1;
	}
}
