public class Solution {
    public int maxArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        if(right == -1 || right == 0) return 0;
        while(left < right){
            int temp = height[left] > height[right] ? height[right] * (right - left) : height[left] * (right - left);
            if(temp > max) max = temp;
            if(height[left] > height[right]) right --;
            else left ++;
        }
        return max;
    }
}
