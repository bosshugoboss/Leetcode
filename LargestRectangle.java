public class Solution {
    public int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return largestRectangleRec(height, 0 , height.length - 1);
    }
    
    public int largestRectangleRec(int height[], int start, int end){
        
        if(start > end) return 0;
        int currentMin = height[start];
        int currentMinIndex = start;
        
        for(int index = start; index <= end; index ++){
             if(height[index] < currentMin){
                   currentMinIndex = index;
                   currentMin = height[index];
              }
         }
         
         int currentSum = currentMin * (end - start + 1);
         int leftSum = largestRectangleRec(height, 0, currentMinIndex - 1);
         int rightSum = largestRectangleRec(height, currentMinIndex + 1, end);
         return Math.max(Math.max(currentSum, leftSum), Math.max(currentSum,rightSum));
    }
}
