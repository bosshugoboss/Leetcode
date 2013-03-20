public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int rowIndex = searchRow(matrix, target);
        if(rowIndex == -1) return false;
        return searchColumn(matrix[rowIndex], target);
    }
    public boolean searchColumn(int[] array, int target){
        int left = 0, right = array.length - 1;
        while(left <= right){
           int mid = (left + right) / 2;
           if(array[mid] == target) return true;
           if(array[mid] > target) right = mid -1;
           else left = mid + 1;
        }
        return false;
    }
    
    public int searchRow(int[][] matrix, int target){
        int start = 0;
        int end = matrix.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(matrix[mid][0] == target) return mid;
            if(matrix[mid][0] > target){
               end = mid - 1;
            }
            else{
               start = start + 1;    
            }
        }
        return end;
    }
}
