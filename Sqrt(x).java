public class Solution {
    public int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int left = 0;
        int right = x;
        while(left <= right){
           int mid = left + (right - left)/2;
           long result = (long)mid * mid;
           if(result > x) right = mid - 1;
           else left = mid + 1;
        }
        return (int)right;
    }
}
