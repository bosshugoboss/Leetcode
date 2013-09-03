/**
 * Given a number represented as an array of 
 * digits, plus one to the number.
 */ 
public class Solution {
     public int[] plusOne(int[] digits) {
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
 
 /* new */
 public class Solution {
     public int[] plusOne(int[] digits) {
        int carry = 1;
        for(int i = digits.length - 1; i >= 0 ; i--){
            int value = digits[i] + carry;
        	if(value == 10){
        		carry = 1;
        		digits[i] = 0;
        	}
        	else{
        		carry = 0;
        		digits[i] = value;
        		break;
        	}
        }
        if(carry == 1){
        	int[] newArray = new int[digits.length + 1];
        	System.arraycopy(digits, 0, newArray, 1, digits.length);
        	newArray[0] = 1;
        	return newArray;
        }
        else return digits;
    }
}
