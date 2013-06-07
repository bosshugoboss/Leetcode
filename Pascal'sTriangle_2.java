public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Integer[] result = new Integer[rowIndex + 1];
        result[0] = 1;

        for(int count1 = 1; count1 <= rowIndex; count1 ++){
            for(int count2 = count1; count2 >= 1; count2 --){
          	if(count2 == count1) {
        		   result[count2] = 1;
        		}
        		else{
        		result[count2] = result[count2] + result[count2 - 1];
        	    }
        	}
        }
        return new ArrayList<Integer>(Arrays.asList(result));
    }
}
