/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a 
 * point at coordinate (i, ai). n vertical lines are drawn such that the two 
 * endpoints of line i is at (i, ai) and (i, 0). Find two lines, which 
 * together with x-axis forms a container, such that the container contains the most water.
 * Note: You may not slant the container.
 */ 
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
