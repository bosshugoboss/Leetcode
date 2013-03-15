
public class Solution {
    public int maxArea(int[] height) {
        int rightPointer = height.length - 1;
        int leftPointer = 0;
        int max = 0;
        if(height.length <= 1) return 0;
        while(leftPointer < rightPointer){
           max = Math.max(max, Math.min(height[leftPointer],height[rightPointer]) 
                 * (rightPointer -leftPointer));
           if(height[leftPointer] >= height[rightPointer]){
              rightPointer --;
           }
           else{
              leftPointer ++;
           }
        } 
        return max;
    }
     
}
