public class Solution {


     public int maxProfit(int[] prices) {

         int[] back = new int[prices.length];
         int[] forward = new int[prices.length];
  
         
         if(prices.length < 2) return 0;
         int low = prices[0];
         for(int count = 1; count < prices.length; count ++) {
             if(prices[count] < low){
                 low = prices[count];
             }

             forward[count] = Math.max(forward[count - 1], prices[count] - low);
         }

         int high = prices[prices.length - 1];
         int result = 0;
         for(int count = prices.length - 2; count >= 0 ; count --){
            if(prices[count] > high){
              high = prices[count];
            }
             back[count] = Math.max(back[count + 1], high - prices[count]);
             result = Math.max(result, back[count] + forward[count]);

         }
       return result;     
     }
}
