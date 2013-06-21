public class Solution {
    public void sortColors(int[] A) {
       
       int[] numbers =  new int[3];
       for(int count = 0; count < A.length; count ++) {
              numbers[A[count]] ++;

       }

       for(int count = 0; count < A.length; count ++) {
           if(numbers[0] != 0)
             A[count] = 0;
       	   else if(numbers[1] != 0)
       	   	A[count] = 1;
       	   else
       	   	A[count] = 2;

       	   numbers[A[count]] --;
       }
    }
}
