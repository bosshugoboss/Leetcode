public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
       
        ArrayList<String> result = new ArrayList<String>();
        String str = new String("");

        generateRec(n, 0, str.toString(), result);
        return result;
        
    }
    
    private void generateRec(int n, int left, String path, ArrayList<String> result){
        if(path.length() == 2 * n){
            result.add(path);
        }
        else{
            int right = path.length() - left;
            if(left > right){
                StringBuilder temp = new StringBuilder(path);
                temp.append(')');
                generateRec(n, left, temp.toString(), result);
            }
            if(left < n){
             StringBuilder newtemp = new StringBuilder(path);
             newtemp.append('(');
             generateRec(n, left + 1, newtemp.toString(), result);  
            }
        }
    }
}
