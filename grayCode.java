
public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(n == 0) {
           result.add(0);
           return result;
        }
        ArrayList<Integer> prev = grayCode(n - 1);
        result.addAll(prev);
        Collections.reverse(prev);
        for(Integer in  : prev) {
            int newInt = in + bin(n);
          result.add(newInt);
        }
        return result;
    }

    private int bin(int n ) {
    	int result = 1;
    	for(int i = 1 ; i < n ; i ++){
            result *= 2;
    	}
    	return result;
    }
}
