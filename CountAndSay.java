public class Solution {
 

public String countAndSay(int n) {

   String current = "1";
   int count = 1;
   for(; count < n; count ++){

        current = generateNew(current);

   }

   return current;
}


public String generateNew(String current){

    StringBuffer result = new StringBuffer();
    char[] curChar = current.toCharArray();
    int countForCurrent = 0;
    char temp = curChar[0];
    for(int count = 0; count <= curChar.length - 1; count ++){
           

          if(curChar[count] == temp){
              countForCurrent ++;
            continue;
          }
          result.append("" + countForCurrent);
          result.append("" + temp);
          countForCurrent = 1;
          temp = curChar[count];
    }

    result.append("" + countForCurrent);
    result.append("" + temp);
    return result.toString();
}
}
