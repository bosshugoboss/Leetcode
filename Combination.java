public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
           ArrayList<ArrayList<Integer>> result = combineRec(1, n, k);
           return result;
    }
    
    public ArrayList<ArrayList<Integer>> combineRec(int start, int end, int k){
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(k == 1){
          for(int index = start; index <= end; index ++){
           ArrayList<Integer> newAL = new ArrayList<Integer>();
           newAL.add(index);
           result.add(newAL);
          }
          return result;
        }
        for(int index = start; index <= end + 1 - k; index ++){
            ArrayList<ArrayList<Integer>> tempAL = combineRec(index + 1, end, k - 1);
            for(ArrayList<Integer> itr : tempAL){
                itr.add(0,index);
                result.add(itr);
            }
        }
        return result;
    }
}
