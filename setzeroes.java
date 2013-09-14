public class Solution {
    public void setZeroes(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
      
        boolean firstRow = false;
        boolean firstColumn = false;
        for(int i = 0; i < matrix.length; i ++){
            if(matrix[i][0] == 0) firstColumn = true;
            matrix[i][0] == 2;
        }
        for(int j = 0; j < matrix[0].length; j ++){
            if(matrix[0][j] == 0) firstRow = true;
            matrix[0][j] == 2;
        }
        for(int i = 1; i < matrix.length; i ++){
            for(int j = 1; j < matrix[0].length; j ++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i = 0; i < matrix.length; i ++){
            if(matrix[i][0] == 0){
                for(int j
            }
        }
    }
}
