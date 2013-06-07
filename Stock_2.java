public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean in = false;
        int result = 0;
        int tempIn = 0;
        int tempOut = 0;
        for(int count = 0 ; count <= prices.length - 1; ){
            if(!in){
                int tempIndex = getIn(prices, count);
                tempIn = prices[tempIndex];
                count = tempIndex + 1;
                in = true;
            }
            else{
                int tempOutindex = getOut(prices, count);
                tempOut = prices[tempOutindex];
                count = tempOutindex + 1;
                in = false;
                result += tempOut - tempIn;
            }
        }
        return result;
    }
    
    public int getIn(int[] prices, int index){
        int currentLow = index;
        for(int count = index + 1; count <= prices.length - 1; count ++){
            if(prices[count] < prices[currentLow]){
                currentLow = count;
            }
            else{
                return currentLow;
            }
        }
        return currentLow;
    }
    
    public int getOut(int[] prices, int index){
        int currentMax = index;
        for(int count = index + 1; count <= prices.length - 1; count ++){
            if(prices[count] > prices[currentMax]){
                currentMax = count;
            }
            else{
                return currentMax;
            }
        }
        return currentMax;
    }
}
