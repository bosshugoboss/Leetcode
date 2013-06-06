public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
           
           int currentLength = 0;
           ArrayList<String> result = new ArrayList<String>();
           ArrayList<String> tempResult = new ArrayList<String>();
           for(int count = 0 ; count <= words.length - 1; count ++){

               currentLength += words[count].length();
                if(currentLength + tempResult.size() <= L){
           	   	  tempResult.add(words[count]);
           	   }

           	   else{
                   currentLength -= words[count].length();
                   int stringSize =  tempResult.size() == 1 ? 1 : tempResult.size() - 1;
                   int spaceLength = (L - currentLength) / stringSize;
                   int offset = (L - currentLength) % stringSize;
                   StringBuffer str = new StringBuffer();
                   for(int subcount = 0; subcount <= tempResult.size() - 1; subcount ++){
                       
                       str.append(tempResult.get(subcount));
                       int spaceoffset = offset <= 0 ? 0 : 1;
                       
                       if( subcount + 1 != tempResult.size() || tempResult.size() == 1){
                        for(int spacecount = 0; spacecount < spaceLength + spaceoffset; spacecount ++){
                       	       str.append(" ");
                        }
                       }
                       offset--;
                   }
                   result.add(str.toString());
                   tempResult.clear();
                   tempResult.add(words[count]);
                   currentLength = words[count].length();  
           	   }
           }
           StringBuffer str = new StringBuffer();
           for(int subcount = 0; subcount < tempResult.size(); subcount ++){
                if(subcount + 1 != tempResult.size())
                    str.append(tempResult.get(subcount) + " " ); 
                else{
                    str.append(tempResult.get(subcount));
                }
           }
           int lastStringLength = str.toString().length();
           for(int count = 0; count < L - lastStringLength; count ++){
              str.append(" ");
           } 
           result.add(str.toString());
           return result;
    }
}
