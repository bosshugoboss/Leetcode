
public class Solution {
    public int numTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] result = new int[n + 1];
        result[0] = 1;
        result[1] = 1;
        for(int i = 2; i <= n; i ++) {
            for(int count = 0; count < i; count ++) {
          	result[i] += result[i - 1 - count] * result[count]; 
        	}
        }
        return result[n];
    }
}
