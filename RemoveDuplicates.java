public class Solution {
    public int removeDuplicates(int[] A) {
        if(A.length == 0) return 0;
        int now = A[0];
        int unique = 1;        
        int index = 1;
        int nextIndex = findNext(A,A[0],1);
        while(nextIndex < A.length && nextIndex != -1){
             swap(A, index, nextIndex);
             nextIndex = findNext(A, A[index], nextIndex + 1);
             unique ++;
             index ++;
        }
        return unique;
    }
    public void swap(int[] A, int a, int b){
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
    
    public int findNext(int[] A, int target, int startIndex){
        for(; startIndex < A.length; startIndex ++){
            if(A[startIndex] != target)
               return startIndex;
        }
        return -1;
    }
}
