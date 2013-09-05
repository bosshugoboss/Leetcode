public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;
        int[][] result = new int[row][column];
        result[0][0] = 1;
        for(int i = 1; i < row; i ++){
            result[i][0] = (result[i-1][0] == 1  && obstacleGrid[i][0] == 0) ? 1 : 0; 
        }
        for(int i = 1; i < column; i ++){
            result[0][i] = (result[0][i-1] == 1 && obstacleGrid[0][i] == 0) ? 1 : 0;
        }
        for(int i = 1; i < row; i ++){
            for(int j = 1; j < column; j ++){
                if(obstacleGrid[i][j] == 0){
                result[i][j] = result[i-1][j] + result[i][j-1];
                }
            }
        }
        return result[row - 1][column - 1];
    }
}
