public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(num);
        return permuteRec(num, 0, new boolean[num.length]);
    }
    
    private ArrayList<ArrayList<Integer>> permuteRec(int[] num, int start, boolean[] used){
        ArrayList<ArrayList<Integer>> r1 = new ArrayList<ArrayList<Integer>>();
        if(start == num.length) r1.add(new ArrayList<Integer>());
        else{
            for(int i = 0; i < num.length; i ++){
                if(used[i] || (i != 0 && used[i-1] && num[i-1] == num[i])) continue;
                used[i] = true;
                for(ArrayList<Integer> array : permuteRec(num, start + 1, used)){
                    array.add(0, num[i]);
                    r1.add(array);
                }
                used[i] = false;
            }
        }
        return r1;
    }
}
