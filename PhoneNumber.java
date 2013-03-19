public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<String>();
        if(digits.length() == 0) {
            result.add("");   
            return result;
        }
        if(digits.length() == 1){
           ArrayList<Character> charList = getcharList(digits.charAt(0));
           for(Character itr : charList){
               StringBuffer str = new StringBuffer();
               str.append(itr);
               result.add(str.toString());
           }
           return result;
        }
        
        char toInsert = digits.charAt(0);
        ArrayList<String> insertList = letterCombinations(digits.substring(1,digits.length()));
        for(Character itr : getcharList(toInsert)){
           for(String insertString : insertList){
               StringBuffer str = new StringBuffer();
               str.append(itr);
               str.append(insertString);
               result.add(str.toString());
           }  
         }
        
        return result;
    }
    
    public ArrayList<Character> getcharList(char input){
           ArrayList<Character> result = new ArrayList<Character>();
           switch(input){
             case '2': result.add('a');
                       result.add('b');
                       result.add('c');
                       break;
             case '3': result.add('d');
                       result.add('e');
                       result.add('f');
                       break;
             case '4': result.add('g');
                       result.add('h');
                       result.add('i');
                       break;
             case '5': result.add('j');
                       result.add('k');
                       result.add('l');
                       break;
             case '6': result.add('m');
                       result.add('n');
                       result.add('o');
                       break;
             case '7': result.add('p');
                       result.add('q');
                       result.add('r');
                       result.add('s');
                       break;
             case '8': result.add('t');
                       result.add('u');
                       result.add('v');
                       break;
             case '9': result.add('w');
                       result.add('x');
                       result.add('y');
                       result.add('z');
                       break;                       
           }
        return result;       
              
    }
}
