public class Solution {
    public int[] searchRange(int[] A, int target) {
           int[] result = {-1, -1};
           if(search(A, target) != -1 && A[search(A, target)] == target){
               result[0] = search(A, target - 1) + 1;
               result[1] = search(A, target);
           }
           return result;
    } 
    public int search(int[] A, int target){
        int left = 0, right = A.length - 1;
        int largestIndex = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(A[mid] > target)
               right = mid - 1;
            else if(A[mid] <= target){ 
               left = mid + 1;
               largestIndex = mid;
            }   
        }
       return largestIndex;
    }    
}
