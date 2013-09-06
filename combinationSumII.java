public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        combinationSumRec(num, 0, target, path, result);
        return result;
    }
    
    private void combinationSumRec(int[] num, int start, int target, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> result){
        
        if(target < 0) return;
        if(target == 0){
            ArrayList<Integer> newA = new ArrayList<Integer>(path);
            result.add(newA);
        }
        else{
            for(int i = start; i < num.length; i ++){
                if(i > start && num[i] == num[i-1]) continue;
                path.add(num[i]);
                combinationSumRec(num, i + 1, target - num[i], path, result);
                path.remove(path.size() - 1);
            }
        }
    }
}
