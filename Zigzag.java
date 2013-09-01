public class Solution {
    public String convert(String s, int nRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Map<Integer, ArrayList<Character>> map = new HashMap<Integer, ArrayList<Character>>();
        if(nRows == 1) return s;
        int subLength = nRows*2 - 2;
        for(int i = 0; i < s.length(); i++){
            int position = i % subLength;
            int row = 0;
            if(position <= nRows - 1) row = position % nRows;
            else row = subLength - position;
            if(map.containsKey(row)){
                map.get(row).add(s.charAt(i));
            }
            else{
                ArrayList<Character> array = new ArrayList<Character>();
                array.add(s.charAt(i));
                map.put(row, array); 
            }
        }
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < map.size(); i++){
            for(Character c : map.get(i)){
                str.append(c);
            }
        }
        return new String(str);
    }
}
