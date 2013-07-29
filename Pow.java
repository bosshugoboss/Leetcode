public class Solution {
    public double pow(double x, int n) {
          
       if(n == 0) return 1;
		   if(n == 1) return x;
		   if(x == 1) return 1;
		   if(x == 0) return 0;
		   if(x == -1) return n%2 == 0? 1 : -1;
		   if(n > 1){
         if(n%2 == 0){
			     return pow(x*x, n/2);
			   }
			   else{
			     return x*pow(x, n - 1);
			   }
       }
       else{
         return pow(1/x, -n);
		   }		   
    }
}

