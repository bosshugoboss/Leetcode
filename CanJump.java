public class Solution {
    public boolean canJump(int[] A) {

        int index = 0;
        while(index < A.length - 1){
           if(A[index] == 0) break;
           index = index + A[index];
            
        }
        if(index >= A.length - 1) return true;
        else return false;
    }
}
