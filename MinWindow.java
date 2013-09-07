public class Solution {
    public String minWindow(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < T.length(); i++){
            if(!map.containsKey(T.charAt(i)))
            map.put(T.charAt(i), 1);
            else{
                int temp = map.get(T.charAt(i));
                map.put(T.charAt(i), temp + 1);
            }
        }
        int end = 0;
        boolean findFirst = false;
        Map<Character, Integer> newMap = new HashMap<Character, Integer>(map);
        Map<Character, Integer> countMap = new HashMap<Character, Integer>(map);
        for(; end < S.length(); end ++){   
            if(countMap.containsKey(S.charAt(end))){
                countMap.put(S.charAt(end), countMap.get(S.charAt(end)) - 1);
            }
            if(newMap.size() != 0){       
                if(newMap.containsKey(S.charAt(end))){
                    int temp = newMap.get(S.charAt(end)) - 1;   
                    if(temp == 0) newMap.remove(S.charAt(end));
                    else newMap.put(S.charAt(end), temp);
                }
                if(newMap.size() == 0){
                    findFirst = true;
                    end ++;
                    break;
                }
            }
            else{
                break;
            }
        }
        if(!findFirst) return "";
        int[] result = new int[S.length()];
        result[0] = end;
        int min = result[0];
        String minS = S.substring(0, min);
        for(int i = 1; i <= S.length() - T.length(); i ++){
            //if(end == S.length()) break;
            boolean find = false;
            if(!map.containsKey(S.charAt(i-1))){
             result[i] = result[i-1] - 1;
            }
            else{
                if(countMap.get(S.charAt(i-1)) < 0){
                    result[i] = result[i-1] - 1;
                    countMap.put(S.charAt(i-1), countMap.get(S.charAt(i-1)) + 1);
                }
                else{
                  while(end < S.length()){
                    if(countMap.containsKey(S.charAt(end))){
                        countMap.put(S.charAt(end), countMap.get(S.charAt(end)) - 1);
                    }
                    if(S.charAt(end) == S.charAt(i-1)){
                        countMap.put(S.charAt(end), countMap.get(S.charAt(end)) + 1);
                        find = true;
                        end ++;
                        break;
                    }
                    end ++;
                   }
                   if(!find) break;
                   result[i] = end - i;    
                }
           }
           min = Math.min(result[i], min);
           if(min == result[i])
           minS = S.substring(i, i + min);
        }
        return minS;
    }
}
