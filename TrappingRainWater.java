public class Solution {
    public int trap(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int count = 0;
        int count2 = 0;
        int next = 0;
        for(int index = 0; index <= A.length - 1;){
                
          if((next = nextFeasible(A, index)) != -1){
             int increase = A[next] < A[index]? A[next] : A[index];
             
             count += A[index] + (next - index - 1) * increase;
             index = next;
          }
            /* next equals to -1 */
          else{
              count += A[index];
              index ++;
          }
        }
        for(int index = 0; index <= A.length -1; index ++){
            count2 += A[index];
        }
        return count - count2;
    }
    
    public int nextFeasible(int[] A, int index){
        int next = index + 1;
        int currBest = index + 1;
        /* represent the last element */
        if(index >= A.length - 2) return -1;
        for(; next < A.length; next++){
            
            if(A[next] >= A[index]) return next;
            if(A[currBest] <= A[next]){
                currBest = next;
            }    
        }
        
        return currBest;
    }
}
