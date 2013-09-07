public class Solution {
    public boolean exist(char[][] board, String word) {

        for(int row = 0; row < board.length; row ++){
            for(int column = 0; column < board[row].length; column ++){
                if(board[row][column] == word.charAt(0)){
                  boolean[][] used = new boolean[board.length][board[0].length]; 
                  used[row][column] = true;
                  if(existRec(board, word.substring(1,word.length()), row, column, used)){ 
                    return true;
                  }
                }
            }
        }
        return false;
    }
    
    public boolean existRec(char[][] board, String word, int row, int column, boolean[][] used){
        
        if(word.length() == 0) return true;
        int[][] nextPossible = findNext(board, word.charAt(0), row, column, used);
        for(int index = 0; index < nextPossible.length; index ++){
            int newRow = nextPossible[index][0];
            int newColumn = nextPossible[index][1];
            if(newRow != -1){
             boolean[][] newused = used ;
             newused[newRow][newColumn] = true;
             if(existRec(board, word.substring(1, word.length()), newRow, newColumn, newused))
               return true;
            }
        }
        return false;
    }
    
    public int[][] findNext(char[][] board, char target, int row, int column, boolean[][] used){
           int[][] result = new int[4][2];
           for(int newrow = 0; newrow < result.length; newrow ++)
             for(int newcolumn = 0; newcolumn < result[newrow].length; newcolumn++)
                 result[newrow][newcolumn] = -1;
                
           if(row -1 != -1){
              if(board[row - 1][column] == target && used[row - 1][column] == false) {
                  result[0][0] = row - 1;
                  result[0][1] = column;
              }
           }
           if(row + 1 != board.length){
               if(board[row + 1][column] == target && used[row + 1][column] == false){
                  result[1][0] = row + 1;
                  result[1][1] = column;
              }
           }
           if(column - 1 != -1){
              if(board[row][column - 1] == target && used[row][column - 1] == false){
                  result[2][0] = row;
                  result[2][1] = column - 1;
              }
           }
           if(column + 1 != board[0].length){
              if(board[row][column + 1] == target && used[row][column + 1] == false){
                  result[3][0] = row;
                  result[3][1] = column + 1;
              }
           }
           return result;
    }
}


/* new */

