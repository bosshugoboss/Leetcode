public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int row = triangle.size() - 1;
        ArrayList<Integer> bottom = triangle.get(row);
        while(row >= 0){
            if(row < triangle.size() - 1){
                ArrayList<Integer> temp = new ArrayList<Integer>();
                int start = 0;
                for(Integer i : triangle.get(row)){
                    temp.add(Math.min(bottom.get(start++),bottom.get(start)) + i);
                }
                bottom = temp;
            }
            row --;
        }
        return bottom.get(0);
    }
}
