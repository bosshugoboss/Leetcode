/**
 *  Write an efficient algorithm that searches for a value in an m x n matrix. 
 *  This matrix has the following properties:
 *  Integers in each row are sorted from left to right.
 *  The first integer of each row is greater than the last integer of the previous row.
 */
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


/* new */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int row = -2;
        for(int i = 0; i < matrix.length; i++){
            if(target < matrix[i][0]){
                row = i - 1;
                break;
            }
        }
        if(row == -2) row = matrix.length - 1;
        if(row == -1) return false;
        for(int j = 0; j < matrix[row].length; j++){
            if(matrix[row][j] == target) return true;
        }
        return false;
    }
}
