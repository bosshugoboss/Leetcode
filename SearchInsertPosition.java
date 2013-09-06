public class Solution {
    public int searchInsert(int[] A, int target) {
           int left = 0, right = A.length - 1;
           int largestIndex = -1;
           while(left <= right){
             int mid = left + (right - left)/2;
             if(A[mid] > target){
                 right = mid - 1;
             }
             else{
                 left = mid + 1;
                 largestIndex = mid;
             }
         }
         if(largestIndex == -1) return 0;
         if(A[largestIndex] == target) return largestIndex;
         else return largestIndex + 1;
    }
} 
/*new */
public class Solution {
    public int searchInsert(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        int mid = 0;
        while(start <= end){
            mid = (start + end)/2;
            if(A[mid] == target) return mid;
            if(A[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return A[mid] < target ? mid + 1: mid ;
    }
}
