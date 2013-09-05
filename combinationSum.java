public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        Arrays.sort(candidates);
        combinationSumRec(candidates, 0, target, path, result);
        return result;
    }
    
    private void combinationSumRec(int[] array, int start, int target, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> result){
        if(target < 0) return;
        if(target == array[start] || target == 0){
            ArrayList<Integer> newA = new ArrayList<Integer>(path);
            if(target != 0) newA.add(target);
            result.add(newA);
        }
        else{
           for(int i = start; i < array.length; i ++){
              path.add(array[i]);
              combinationSumRec(array, i, target - array[i], path, result);
              path.remove(path.size() - 1);
           }   
        }
    }
}
