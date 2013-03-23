public class Solution {
    public int numTrees(int n) {

        if(n == 1 || n == 2) return n;
        int[] resultset = new int[n + 1];
        resultset[0] = 1;
        resultset[1] = 1;
        resultset[2] = 2;
        for(int index = 3; index <= n; index ++){
            for(int subIndex = 1; subIndex <= index; subIndex ++){
               resultset[index] += resultset[index - subIndex] * resultset[subIndex - 1];   
            }            
        }
        return resultset[n];
    }
}
