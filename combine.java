public class Solution {
    public ArrayList<ArrayList<Integer>> result;
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        result = new ArrayList<ArrayList<Integer>>();
        if(n < k) return null;
        ArrayList<Integer> trans = new ArrayList<Integer>();
        combineRec(trans, 1, k, 1, n - k + 1);
        return result;
    }

    public void combineRec(ArrayList<Integer> trans, int n, int k, int start, int end){
        if(n == k + 1){
           result.add(trans);
           return;    
        } 
        for(int count = start; count <= end ; count ++ ){   
            ArrayList<Integer> newTran = new ArrayList<Integer>(trans);
            newTran.add(count);
            combineRec(newTran, n + 1, k , count + 1, end + 1);
        }
    }
}
