public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> result = new ArrayList<Integer>();
        Map<String, Integer> mapL = new HashMap<String, Integer>();
        Map<String, ArrayList<Integer>> mapList = new HashMap<String, ArrayList<Integer>>();
        for(int i = 0; i < L.length; i ++){
            if(mapList.get(L[i]) == null)
              mapList.put(L[i], new ArrayList<Integer>());
            mapList.get(L[i]).add(i);
            mapL.put(L[i], 0);
        }
        int commonL = L[0].length();
        for(int i = 0; i <= S.length() - L.length*commonL; i ++){
            Map<String, Integer> map = new HashMap<String, Integer>(mapL);   
            boolean[] used = new boolean[L.length];
            int tempI = i;
            String temp = S.substring(tempI, tempI + commonL); 
            int length = 0;
            while(map.containsKey(temp)){
                int index = map.get(temp);
                if(index >= mapList.get(temp).size()) break;
                int usedIndex = mapList.get(temp).get(index);
                if(used[usedIndex]) break;
                map.put(temp, index + 1);
                length ++;
                used[usedIndex] = true;
                tempI += commonL;
                if(tempI + commonL > S.length()) break;
                temp = S.substring(tempI, tempI + commonL);
            }
            if(length == L.length) result.add(i);
        }
        return result;
    }
}
