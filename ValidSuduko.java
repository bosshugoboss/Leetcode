public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashSet<Character> set = new HashSet<Character>();
        for(int num = 0; num < board.length; num ++){
            set.clear();
            for(int num1 = 0; num1 < board[0].length; num1 ++){
                if(board[num][num1] != '.'){
                   if(set.contains(board[num][num1])) return false;
                   set.add(board[num][num1]);
                }
            }
        }
        

        for(int num = 0; num < board.length; num ++){
            set.clear();
            for(int num1 = 0; num1 < board[0].length; num1 ++){
                if(board[num1][num] != '.'){
                   if(set.contains(board[num1][num])) return false;
                   set.add(board[num1][num]);
                }
            }
        }
        
        boolean result = true;
        for(int num = 0 ; num < board.length; num += 3){
            for(int num1 = 0 ; num1 < board[0].length; num1 += 3){
                result = splitTest(board, num, num1);
                if(result == false) return result;
            } 
        }
        return result;         
    }

    public boolean splitTest(char[][] board, int i , int j){

        HashSet<Character> set = new HashSet<Character>();
        for(int num = i; num < i + 3; num ++){
            for(int num1 = j; num1 < j + 3; num1 ++){
              if(board[num][num1] != '.'){
                  if(set.contains(board[num][num1])) return false;
                  set.add(board[num][num1]);
              }
            }
        }
        return true;
    }
}
