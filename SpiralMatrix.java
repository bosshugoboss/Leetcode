public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> result = new ArrayList<Integer>();
        spiralOrderRec(result, matrix, 0, 0);
        return result;
    }
    
    public void spiralOrderRec(ArrayList<Integer> result, int[][] matrix, int rowStart, int columnStart){
          if(2 * rowStart >= matrix.length) return;
          if(2 * columnStart >= matrix[0].length) return;
          if(rowStart == matrix.length /2){
              for(int columnIndex = columnStart; columnIndex < matrix[0].length - columnStart; columnIndex ++)
                result.add(matrix[rowStart][columnIndex]);
                return;
          }
          else if(columnStart == matrix[0].length / 2){
              for(int rowIndex = rowStart; rowIndex < matrix.length - rowStart; rowIndex ++)
                result.add(matrix[rowIndex][columnStart]);
                return;
          }
          else{
              for(int columnIndex = columnStart; columnIndex < matrix[0].length - columnStart; columnIndex ++)
                result.add(matrix[rowStart][columnIndex]);
              for(int rowIndex = rowStart + 1; rowIndex < matrix.length - rowStart - 1; rowIndex ++)
                result.add(matrix[rowIndex][matrix[0].length - columnStart - 1]);
              for(int columnIndex = matrix[0].length - columnStart - 1; columnIndex >= columnStart; columnIndex --)
                result.add(matrix[matrix.length - rowStart - 1][columnIndex]);
              for(int rowIndex = matrix.length - rowStart - 2; rowIndex > rowStart ; rowIndex --)
                result.add(matrix[rowIndex][columnStart]);
              spiralOrderRec(result, matrix, rowStart + 1, columnStart + 1);    
          }
    }
}
