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
         if(A[largestIndex] == target) return largestIndex;
         else return largestIndex + 1;
    }
} 
