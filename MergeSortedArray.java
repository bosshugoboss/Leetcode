public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int indexA = m - 1;
        int indexB = n - 1;
        int totalIndex = m + n -1;
        for(;totalIndex >= 0 ; totalIndex --){
            if(indexA == -1){
                A[totalIndex] = B[indexB];
                indexB --;
            }
            else if(indexB != -1){
                 if(A[indexA] > B[indexB]){             
                   A[totalIndex] = A[indexA --];
                 }
                 else{
                   A[totalIndex] = B[indexB --];
                }
            }
        }
    }
}
