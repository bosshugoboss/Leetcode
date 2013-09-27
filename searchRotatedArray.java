public class Solution {
    public int search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int start = 0;
        int end = A.length - 1;
        while(start <= end){
            int mid = (start + end)/2;
            if(A[mid] == target) return mid;
            if(A[start] <= A[mid]){
                if(target < A[mid] && target >= A[start])
                   end = mid - 1;
                else if(target < A[mid] && target < A[start])
                   start = mid + 1;
                else
                   start = mid + 1;
            }
            else{
                if(target > A[mid] && target > A[end])
                   end = mid - 1;
                else if(target > A[mid] && target <= A[end])
                   start = mid + 1;
                else
                   end = mid - 1;
                   
            }
        }
        return -1;
    }
}
