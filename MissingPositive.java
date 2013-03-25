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
