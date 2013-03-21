/**
 * A message containing letters from A-Z is being 
 * encoded to numbers using the following mapping:
 */ 
public class Solution {
     public int numDecodings(String s) {
         if(s == null || s.equals("")) return 0;
         int[] solution = new int[s.length()];
         if(s.charAt(0) == '0') solution[0] = 0;
         else solution[0] = 1;
         if(s.length() == 1) return solution[0];
         if(s.charAt(1) == '0'){
            if(s.charAt(0) < '3') solution[1] = solution[0];
            else solution[1] = 0;
         }
         else{
            if(Integer.parseInt(s.substring(0,2)) <= 26 &&
                    s.charAt(0) != '0' ) solution[1] = 2;
            else solution[1] = solution[0];
         }
         for(int index = 2; index < s.length(); index ++){
             if(s.charAt(index) != '0'){
                solution[index] += solution[index - 1];
                if(s.charAt(index - 1) != '0'
                && Integer.parseInt(s.substring(index - 1, index + 1)) <= 26)
                 solution[index] += solution[index - 2];
             }
             else{
                if(s.charAt(index - 1) == '0'
                || s.charAt(index - 1) > '2') solution[index] = 0;
                else solution[index] = solution[index - 2];
             }
         }
         return solution[s.length() - 1];
     }
 }
