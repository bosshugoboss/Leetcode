public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int[] remain = new int[gas.length];
        int remainder = 0;
        int current = 0;
        int run = 0;
        boolean right = true;
        for(int i = 0; i < remain.length; i ++){
            remain[i] = gas[i] - cost[i];
            remainder += remain[i];
        }
        if(remainder < 0) return -1;
        remainder = 0;
        while(current < gas.length){
           for(run = current; run < gas.length; run ++){
               remainder += remain[run];
               if(remainder < 0) break;
           }
           if(run == gas.length) return current;
           remainder = 0;
           current = run + 1;
        }
        return -1;
    }
}
