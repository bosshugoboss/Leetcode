public class Solution {
    public int threeSumClosest(int[] num, int target) {
           int result;
           Arrays.sort(num);
           result = num[0] + num[1] + num[2];
           int nearest = Math.abs(result - target);
           for(int index = 0; index < num.length; index ++){
              int leftPointer = index + 1;
              int rightPointer = num.length - 1;
              int remainder = target - num[index];
              while(rightPointer > leftPointer){
                  if(remainder - num[leftPointer] == num[rightPointer]){
                     return target;
                  }
                  nearest = Math.min(nearest,Math.abs(num[leftPointer] + num[rightPointer] - remainder));
                  if(Math.abs(num[leftPointer] + num[rightPointer] - remainder) == nearest){
                     result = num[index] + num[leftPointer] + num[rightPointer]; 
                  }
                  if(remainder - num[leftPointer] > num[rightPointer]){                
                     leftPointer ++;
                  }
                  else{
                     rightPointer --;
                  }
              }
           }
         return result;
    }
}
