public class Solution {
    public String longestCommonPrefix(String[] strs) {
          if(strs.length == 1) return strs[0];
          if(strs.length == 0) return "";
          String common = strs[0];
          for(int index = 0; index + 1 < strs.length; index ++){
              common = commonPrefix(common, strs[index + 1]);
          }
          return common;
    }
    
    public String commonPrefix(String a, String b){
        StringBuffer str = new StringBuffer();
        int index = 0;
        while(index < a.length() && index < b.length()){
            if(a.charAt(index) == b.charAt(index)){
                str.append(a.charAt(index));
            }
            else{
                break;
            }
            index ++;
        }
        return str.toString();
    }
}
