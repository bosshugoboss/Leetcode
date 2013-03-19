/**
 *  Given an array S of n integers, are there elements a, b, c 
 *  in S such that a + b + c = 0? Find all unique triplets 
 *  in the array which gives the sum of zero. 
 */
 
public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num){         
           ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
           Arrays.sort(num);
           for(int index = 0; index < num.length; index ++){
               int remainder =  0 - num[index];
               int leftPointer = 0;
               int rightPointer = num.length - 1;
               while(leftPointer < rightPointer){
                   if(leftPointer == index){
                      leftPointer ++; 
                   }
                   if(rightPointer == index){
                       rightPointer --;
                   }
                   if(leftPointer < rightPointer){
                      if(remainder - num[leftPointer] == num[rightPointer]){
                         ArrayList<Integer> solution = new ArrayList<Integer>();
                         solution.add(num[leftPointer]);
                         solution.add(num[rightPointer]);
                         if(leftPointer > index) solution.add(0, num[index]);
                         else if(rightPointer > index) solution.add(1, num[index]);
                         else solution.add(num[index]);
                         result.add(solution);
                         leftPointer ++;
                         rightPointer --;
                      }
                      else if(remainder - num[leftPointer] < num[rightPointer])
                         rightPointer --;
                      else 
                         leftPointer ++;
                   }
                   
               }   
           }
           HashSet<ArrayList<Integer>> resultSet = new HashSet<ArrayList<Integer>>();           
           resultSet.addAll(result);
           result.clear();
           result.addAll(resultSet);
           return result;
     }
}
