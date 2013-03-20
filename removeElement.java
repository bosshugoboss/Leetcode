/**
 * Given an array and a value, remove all instances of 
 * that value in place and return the new length. The order 
 * of elements can be changed. It doesn't matter what you 
 * leave beyond the new length.
 */ 
public class Solution {
    public int removeElement(int[] A, int elem) {
          int last = validLast(A, A.length - 1, elem);
          int unique = A.length - (A.length - 1 - last);
          for(int index =  0; index < last; index ++){
              if(A[index] == elem){                  
                  swap(A, last, index);
                  int temp = last - 1;
                  last = validLast(A, temp, elem);
                  unique = unique - (temp - last) - 1;
              }
          }   
          return unique;
    }
    
    public int validLast(int[] A, int last, int elem){
        for(; last >= 0; last --){
            if(A[last] != elem) return last;
        }
        return -1;
    }
    
    public void swap(int[] A, int a, int b){
         int temp = A[a];
         A[a] = A[b];
         A[b] = temp;
    }
}
