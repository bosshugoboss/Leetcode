public class Solution {
    public int longestConsecutive(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int max = 0;
    	Set<Integer> nums = new HashSet<Integer>();
        for(int i = 0; i < num.length; i++){
            nums.add(num[i]);
        }
        Set<Integer> newNums = new HashSet(nums);
        for(Integer i : nums){
        	if(newNums.contains(i)){
              int temp = 1;
              int start = i;
              while(newNums.contains(start+1)){
                temp ++;
                newNums.remove(start+1);
                start++;
              }
              start = i;
              while(newNums.contains(start-1)){
                temp ++;
                newNums.remove(start-1);
                start--;
              }
              if(temp > max) max = temp;
        	}
        }
        return max;
    }
}
