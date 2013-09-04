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


/* new */
public class Solution {
    public int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Stack<Integer> stack = new Stack<Integer>();
        int maxArea = 0;
        int i = 0;
        int[] h = new int[height.length + 1];
        h = Arrays.copyOf(height, height.length + 1);
        height = h;
        while(i < height.length){
            if(stack.isEmpty() || height[stack.peek()] <= height[i]){
                stack.push(i++);
            }
            else{
                int temp = stack.pop();
                maxArea = Math.max(maxArea, height[temp] * (stack.isEmpty()? i : i - stack.peek() - 1));
            }
        }
        return maxArea;
    }
}
