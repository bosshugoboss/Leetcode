public class Solution {
    public void rotate(int[][] matrix){
         rotateRec(matrix, matrix.length, 0);
  }
    public void rotateRec(int[][] matrix, int length, int start) {
       if(length == 1 || length ==0) return;
		   int row = start;
		   int bottom = matrix.length - start - 1;
		   for(int i = 0; i < length - 1; i++){
		     int mid = matrix[row][start + i];
			   matrix[row][start + i] = matrix[bottom - i][row];
			   matrix[bottom - i][row] = matrix[bottom][bottom - i];
			   matrix[bottom][bottom - i] = matrix[start + i][bottom];
			   matrix[start + i][bottom] = mid;
		 }
		 rotateRec(matrix, length - 2, start + 1);
    }
}
