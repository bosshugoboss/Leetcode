public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return generate(n,n);
    }
    
    public ArrayList<String> generate(int leftremain, int rightremain){
        ArrayList<String> result = new ArrayList<String>();
        if(rightremain == 1 && leftremain == 0){
           result.add(")");
           return result;
        }
        
        if(leftremain <= rightremain && leftremain >= 1){
           ArrayList<String> remainderAL = generate(leftremain - 1, rightremain);
           for(String str : remainderAL){
               StringBuffer sb = new StringBuffer();
               sb.append('(');
               sb.append(str);
               result.add(sb.toString());
           }
        }
        if(leftremain < rightremain){           
           ArrayList<String> remainderAL = generate(leftremain, rightremain - 1);
           for(String str : remainderAL){
               StringBuffer sb = new StringBuffer();
               sb.append(')');
               sb.append(str);
               result.add(sb.toString());
           }
        }
      return result;
    }
}
