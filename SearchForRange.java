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

/*new */
public class Solution {
    public int[] searchRange(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] result = {-1, -1};
        if(search(A,target) != -1 && A[search(A,target)] == target){
            result[0] = search(A,target - 1) + 1;
            result[1] = search(A,target);
        }
        return result;
    }
    
    private int search(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        int result = -1;
        
        while(start <= end){
            int mid = (start + end) / 2;
            if(A[mid] <= target){
                start = mid + 1;
                result = mid;
            }
            else end = mid - 1;
        }     
        return result;
    }
}
