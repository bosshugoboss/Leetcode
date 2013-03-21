public class Solution {
     public int[] plusOne(int[] digits) {
         // Start typing your Java solution below
         // DO NOT write main() function
         int length = digits.length;
         int index = 0;
         if(digits[length - 1] != 9){
            digits[length - 1] ++;
            return digits;
         }
         for(index = length - 2; index >= 0; index --){
             if(digits[index] != 9) break;
         }
         if(index != -1){
             for(int a = length - 1; a > index; a --)
               digits[a] = 0;
             digits[index] ++;
             return digits;
         }
         else{
             int[] result = new int[length + 1];
             result[0] = 1;
             return result;
         }
     }
 }
