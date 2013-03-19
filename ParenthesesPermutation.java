/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */
public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
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
