/**
 *  You are climbing a stair case. It takes n steps to reach to the top. 
 *  Each time you can either climb 1 or 2 steps. 
 *  In how many distinct ways can you climb to the top?
 */ 
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
