public class Solution {
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean[][] resultTable = new boolean[p.length() + 1][s.length() + 1];
        resultTable[0][0] = true;
        for(int row = 1; row < p.length() + 1; row ++){
            for(int column = 0; column < s.length() + 1; column ++){            
                if(column == 0){
                   if(p.charAt(row - 1) == '*')
                      resultTable[row][0] = resultTable[row - 1][0];
                }

                else if(p.charAt(row - 1) == s.charAt(column - 1)
                      ||p.charAt(row - 1) == '?'){
                    resultTable[row][column] = resultTable[row - 1][column - 1];
                }
                else if(p.charAt(row - 1) == '*'){
                    boolean search = false;
                    for(int subRow = row - 1; subRow <= row ; subRow ++){
                      for(int subColumn = 0; subColumn <= column; subColumn ++){
                          if(resultTable[subRow][subColumn] == true){
                             resultTable[row][column] = true;
                             search = true;
                             break;                          
                          }
                      }
                      if(search == true) break;
                    }  
                }
                else resultTable[row][column] = false;
            }
        }
        return resultTable[p.length()][s.length()];
    }
}
