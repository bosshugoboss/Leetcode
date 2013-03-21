public class Solution {
    public int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n == 1) return 1;
        int[] array = new int[n];
        array[0] = 1;
        array[1] = 2;
        for(int index = 2; index < n; index ++){
            array[index] = array[index - 1] +  array[index - 2];
        }
        return array[n - 1];
    }
}
