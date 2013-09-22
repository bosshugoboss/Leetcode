public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> result = new ArrayList<String>();
        StringBuffer path = new StringBuffer();
        restoreRec(s, path, 0, result);
        return result;
    }
    
    private void restoreRec(String rest, StringBuffer path, int dot, ArrayList<String> result){
        if(dot == 4 ){
            if(rest.length() != 0) return;
            path.deleteCharAt(path.length() - 1);
            result.add(path.toString());
            return;
        }
        else{
            if(rest.length() == 0){
                return;
             }
            if(rest.charAt(0) == '0'){
                StringBuffer newPath = new StringBuffer(path);
                newPath.append(rest.substring(0,1)+".");
                restoreRec(rest.substring(1, rest.length()), newPath, dot + 1, result); 
            }
            else{
              if(rest.length() >= 3 && Integer.valueOf(rest.substring(0, 3)) <= 255){
                StringBuffer newPath = new StringBuffer(path);
                newPath.append(rest.substring(0,3)+".");
                restoreRec(rest.substring(3, rest.length()), newPath, dot + 1, result); 
              }
             if(rest.length() >= 2){
                StringBuffer newPath = new StringBuffer(path);
                newPath.append(rest.substring(0,2) + ".");
                restoreRec(rest.substring(2, rest.length()), newPath, dot + 1, result);
             }
             if(rest.length() >= 1){
                StringBuffer newPath = new StringBuffer(path);
                newPath.append(rest.substring(0,1) + ".");
                restoreRec(rest.substring(1,rest.length()), newPath, dot + 1, result);
             }
           }
        }
    }
}
