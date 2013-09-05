/**
 *  Given a collection of numbers, return all possible permutations.
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
         
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> subResult = new ArrayList<Integer>();
        if(num.length == 1){
           subResult.add(num[0]);
           result.add(subResult);
           return result;        
        }
        for(int index = 0; index < num.length; index ++){
            int[] remainder = eliminate(num, index); 
            ArrayList<ArrayList<Integer>> back = permute(remainder);
            for(ArrayList<Integer> itr : back){
                itr.add(0,num[index]);
                result.add(itr);
            }
        }
        return result;
    }
    
    public int[] eliminate(int[] num, int index){
        
        int [] result = new int[num.length - 1];
        int j = 0;
        for(int i = 0; i < num.length; i++){
            if(i!= index){
               result[j++] = num[i];
            }
        }
        return result;
    }
}

/*new */
public class Solution {
        public ArrayList<ArrayList<Integer>> permute(int[] num) {
                // Start typing your Java solution below
                // DO NOT write main() function
	            ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	            ArrayList<ArrayList<Integer>> current = new ArrayList<ArrayList<Integer>>();
	            permuteRec(num, 0, num.length, current, result);
	            return result;
	    }
	        
	    private void permuteRec(int[] num, int start, int end, ArrayList<ArrayList<Integer>> current, ArrayList<ArrayList<Integer>> result){
	            if(start == end){
	               for(ArrayList<Integer> array : current){
	                   result.add(array);
	               }
	            }
	            else{
	                for(int i = start; i < end; i ++){
	                    swap(num, start, i);
	                    ArrayList<ArrayList<Integer>> newCurrent = new ArrayList<ArrayList<Integer>>();
	                    if(current.size() == 0){
	                    	ArrayList<Integer> p = new ArrayList<Integer>();
	                    	p.add(num[start]);
	                    	newCurrent.add(p);
	                    }
	                    for(ArrayList<Integer> array : current){
	                        ArrayList<Integer> newA = new ArrayList<Integer>(array);
	                        newA.add(num[start]);
	                        newCurrent.add(newA);
	                    }
	                    permuteRec(num, start + 1, end, newCurrent, result);
	                    swap(num, i, start);
	                }
	            }
	        }
	        private void swap(int[] num, int a, int b){
	            int temp = num[a];
	            num[a] = num[b];
	            num[b] = temp;
	        }
}
