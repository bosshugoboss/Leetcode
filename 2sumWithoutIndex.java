public class Solution {
    public int[] twoSum(int[] numbers, int target) {
           int remainder = 0;
           int[] result = new int[2];
           if(numbers.length < 2) return result; 
           int rightPointer, leftPointer;
           leftPointer = 0;
           rightPointer = numbers.length - 1;
           Arrays.sort(numbers);
           while(rightPointer > leftPointer){
               remainder = target - numbers[leftPointer];
               if(numbers[rightPointer] == remainder){
                  result[0] = numbers[leftPointer];
                  result[1] = numbers[rightPointer];
                  return result;
               }
               else if(numbers[rightPointer] < remainder)
                  leftPointer ++;
               else
                  rightPointer --;
           }
          return result;
    }
}
