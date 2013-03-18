

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
          
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        for(int index = 0; index < numbers.length; index ++){
            if(map.containsKey(numbers[index])){
               result[0] = map.get(numbers[index]) + 1;
               result[1] = index + 1;
               return result;
            }            
            else{
                map.put(target - numbers[index], index);                
            }
        }
        return result;
    }
}
