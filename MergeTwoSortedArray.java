public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int indexforA = m - 1;
        int indexforB = n - 1;
        int length = m + n -1;
        while(indexforA != -1 && indexforB != -1){
        
             if(A[indexforA] > B[indexforB]){
                 A[length] = A[indexforA];
                 indexforA --;
             }
             else{
                 A[length] = B[indexforB];
                 indexforB --;
             }
             
             length --;
        } 
        
        while(indexforA != -1){
            A[length --] = A[indexforA --];
        }
        
        while(indexforB != -1){
            A[length --] = B[indexforB --];
        }
    }
}
