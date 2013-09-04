public class Solution {
    public int uniquePaths(int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
            n = n - 1;
	        int sum = m + n ;
	        int rest = m > n ? n : m;
	        int start = sum - rest + 1;
	        long restCum = 1;
	        long startCum = 1;
	        int i = 1;
	        while(i <= rest){
	            restCum *= i++;
	        }
	        i = start;
	        while(i <= sum){
	            startCum *= i++;
	        }
	        return (int)(startCum/restCum);
    }
}
