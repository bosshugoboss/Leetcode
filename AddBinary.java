public class Solution {
    public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int length = a.length() >= b.length() ? a.length() + 1 : b.length() + 1;
        char[] result = new char[length];
        char[] hello = new char[3];

        
        int first = a.length() - 1;
        int second = b.length() - 1;
        int index = length - 1;
        int carry = 0;
        while(first >= 0 || second >= 0){
            char fchar = first >=0 ? a.charAt(first) : '0';
            char schar = second >= 0 ? b.charAt(second) : '0';
            if(carry == 0){
                if(fchar == '1' && schar == '1'){
                   result[index] = '0';
                   carry = 1;
                }
                else{
                   if(fchar == '0' && schar =='0') result[index] = '0';
                   else result[index] = '1';
                   carry = 0;
                }
            }
            else{
                if(fchar == '0' && schar == '0'){
                   result[index] = '1';
                   carry = 0;
                }
                else{
                    if(fchar == '1' && schar == '1'){
                        result[index] = '1';
                    }
                    else result[index] = '0';
                    carry = 1;
                }
            }
            index --;
            first --;
            second --;
        }
        if(carry == 1) {
            result[index] = '1';
            return new String(result);
        }
        return new String(result).substring(1,length); 
    }
}


new version:

public class Solution {
    public String addBinary(String k, String m) {
        int carry = 0;
        String a = (new StringBuilder(k)).reverse().toString();
        String b = (new StringBuilder(m)).reverse().toString();
        StringBuilder result = new StringBuilder();
        int length = a.length() > b.length() ? a.length() : b.length();
        int i = 0;
        int minus = '0';
        while(i < length){
            int value = 0;
            if(i < a.length() && i < b.length()){
                value = carry + Integer.valueOf(a.charAt(i)) + Integer.valueOf(b.charAt(i)) - 2* minus;
            }
            else{
                if(i >= a.length()){
                 value = carry + Integer.valueOf(b.charAt(i)) - minus;
                }
                else{
                 value = carry + Integer.valueOf(a.charAt(i)) - minus;
                }
            }
            if(value >= 2) {
                carry = 1;
                result.append(value - 2);
            }
            else {
                carry = 0;
                result.append(value);
            }
            i++;
        }
        if(carry == 1) result.append(carry);
        return new String(result.reverse());
    }
}
