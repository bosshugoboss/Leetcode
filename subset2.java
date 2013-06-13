public class Solution {
    
    HashSet<String> set;
    HashMap<ArrayList<Integer>, String> map;
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        set = new HashSet<String>();
        map = new HashMap<ArrayList<Integer>, String>();
        return subsetsHelper(num, 0, num.length - 1);
    }
    
    private ArrayList<ArrayList<Integer>> subsetsHelper(int[] num, int startIndex, int endIndex) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(startIndex > endIndex) {
            ArrayList<Integer> newOne = new ArrayList<Integer>();
            result.add(newOne);
            map.put(newOne, newOne.toString());
            set.add(newOne.toString());
            return result;
        }
        ArrayList<ArrayList<Integer>> oldresult = subsetsHelper(num, startIndex, endIndex - 1);
        for(ArrayList<Integer> iter : oldresult){
            String newString = map.get(iter);
            
            ArrayList<Integer> newArray = new ArrayList<Integer>(iter);
            newArray.add(num[endIndex]);
            Collections.sort(newArray);
            if(!set.contains(newArray.toString())){
                map.put(newArray, newArray.toString());
                set.add(newArray.toString());                
                result.add(newArray);
            }
            result.add(iter);
        }
        return result;
    }
}
