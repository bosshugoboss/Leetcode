public class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int prefix = 0;
        if(strs.length == 0) return "";
        char c;
        for(int i = 0; i < strs[0].length(); i++){
            c = strs[0].charAt(i);
            for(int j = 1; j < strs.length; j++){
                if(strs[j].length() <= i || strs[j].charAt(i) != c){
                    return strs[0].substring(0,prefix);
                }
            }
            prefix ++;
        }
        return strs[0].substring(0,prefix);
    }
}
