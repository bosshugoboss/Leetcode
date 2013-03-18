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
