public class Solution {
    public void nextPermutation(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
      int start = num.length - 1;
      while(start > 0){
         if(num[start] > num[start - 1])
          break;
         start --;
      }
      if(start == 0) Arrays.sort(num);
      else{
        int replace = searchNext(num, start, num[start - 1]);
        int temp = num[replace];
        num[replace] = num[start - 1];
        num[start - 1] = temp;
        Arrays.sort(num, start, num.length);
      }
      
    }
    
    public int searchNext(int[] num, int start, int item){
        int index = start;
        for(int i = start; i < num.length; i++){
            if(num[i] < num[index] && num[i] > item){
               index = i;
            }
        }
        return index;
    }
}
