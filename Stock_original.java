public class Solution {
    public int maxProfit(int[] prices) {
       
         if(prices.length == 0) return 0;
         int tempLow = prices[0];
         for(int count = 0; count < prices.length; count ++){
             if(prices[count] < tempLow){
                tempLow = prices[count];
             }
             prices[count] = prices[count] - tempLow;
         }
    
         int result = 0;
         for(int count = 0; count < prices.length; count ++){
             if(prices[count] > result){
                 result = prices[count];
             }
         }
         return result;
    }
}
