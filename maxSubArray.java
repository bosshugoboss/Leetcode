public class Solution {
    public int maxSubArray(int[] A) {
        for(int i = 1; i < A.length; i ++){
            A[i] = A[i-1] <=0 ? A[i] : A[i-1] + A[i];
        }
        int max =  A[0];
        for(int i = 1; i < A.length; i ++){
            max = Math.max(max, A[i]);
        }
        return max;
    }    
}
