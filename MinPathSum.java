public class Solution {
    public static int min = Integer.MAX_VALUE;
    public int minPathSum(int[][] grid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        min = Integer.MAX_VALUE;
        dfs(grid, 0, 0, 0);    
        return min;
    }
    public void dfs(int[][] grid, int i, int j, int sum){
        if(i == grid.length - 1 && j == grid[0].length - 1){
           sum += grid[i][j];
           min = Math.min(min, sum);
        }
        if(i < grid.length - 1) dfs(grid, i + 1, j, sum + grid[i][j]);
        if(j < grid[0].length - 1) dfs(grid, i, j + 1, sum + grid[i][j]);
    } 
}
