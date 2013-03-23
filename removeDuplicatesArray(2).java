public class Solution {
    public int removeDuplicates(int[] A) {

        if(A.length == 0 || A.length == 1) return A.length;
        int length = 2;
        int index = 2;
        int nextIndex = 2;
        boolean twice = A[0] == A[1] ? true : false;
        while(nextIndex < A.length){
             if(twice){
                nextIndex = findNext(A, A[index - 1], nextIndex);
                if(nextIndex == -1) break;
                swap(A, index, nextIndex);
                twice = false;
             }
             else{
                A[index] = A[nextIndex];
                twice = A[index - 1] == A[index] ? true : false;
             }
             nextIndex ++;
             index ++;
             length ++;
        }
        return length;
    }

    public void swap(int[] A, int a, int b){
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }

    public int findNext(int[] A, int target, int index){
        for(int a = index; a < A.length; a ++){
            if(A[a] != target) return a;
        }
        return -1;
    }
}
