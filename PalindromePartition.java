public class Solution {
        public ArrayList<ArrayList<String>> partition(String s) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        boolean[][] isPal = new boolean[s.length()][s.length()];
	        for(int i = 0; i < s.length(); i++){
	            isPal[i][i] = true;
	            if(i >= 1) isPal[i-1][i] = s.charAt(i-1) == s.charAt(i);
	        }
	        for(int i = 1; i < s.length(); i++){
	            for(int j = i - 2; j >= 0; j--){
	                isPal[j][i] = (s.charAt(i) == s.charAt(j)) && isPal[j+1][i-1];
	            }
	        }
	        return partitionHelper(s, 0, isPal);
	    }
	    
	    public ArrayList<ArrayList<String>> partitionHelper(String s, int start, boolean[][] isPal){
	        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
	        if(s.length() == start){
	          ArrayList<String> array = new ArrayList<String>();
	          result.add(array);
	          return result;
	        }
	        for(int i = start; i < s.length(); i ++){
	            if(isPal[start][i]){
	                for(ArrayList<String> list : partitionHelper(s, i+1, isPal)){
	                    list.add(0, s.substring(start, i+1));
	                    result.add(list);
	                }
	            }
	        }
	        return result;
	    }
}
