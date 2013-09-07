public class Solution {
    public int firstMissingPositive(int[] A) {
        
        int length = getAllPositive(A);
        
        int result = 0;
        for(int index = 0; index <= length; index ++){
            if(Math.abs(A[index]) <= length + 1){                
               A[Math.abs(A[index]) - 1] = 0 - Math.abs(A[Math.abs(A[index]) - 1]);   
            }                          
        }            
        for(; result <= length; result ++){
            if(A[result] > 0)
               break;
        }
        return result + 1;        
    }
    
    public int getAllPositive(int[] A){        
        int start = 0;
        int end = A.length - 1;
        
        while(start <= end){
           if(A[start] > 0){
              start ++;
           }    
           else{
             swap(A, start, end);
             end --;
           }            
        }   
        return start - 1;
    }
    
    public void swap(int[] A, int a, int b){        
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
}


/* new */

public class Solution {
    public int firstMissingPositive(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int positiveLength = getAllPositive(A);
        
        for(int i = 0; i < positiveLength; i ++){
            if(Math.abs(A[i]) - 1 < A.length)
            A[Math.abs(A[i]) - 1] = - Math.abs(A[Math.abs(A[i]) - 1]);
        }
        
        for(int i = 0; i < positiveLength; i ++){
            if(A[i] > 0){
              return i + 1;
            }
        } 
        return positiveLength + 1;
    }
    
    private int getAllPositive(int[] A){
        int start = 0;
        int end = A.length - 1;
        while(start <= end){
            if(A[start] <= 0){
                swap(A, start, end);
                end --;
            }
            else{
                start ++;
            }
        }
        return start;
    }
    
    private void swap(int[] A, int i , int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
