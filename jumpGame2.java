public class Solution {
    public int jump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int max = 0;
        if(A.length == 1) return 0;
        int[] result = new int[A.length];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(0);
        while(!queue.isEmpty()){
            int temp = queue.poll();
            int prevMax = max;
            max = Math.max(max, temp + A[temp]);
            if(max >= A.length - 1){
                result[A.length - 1] = result[temp] + 1;
                break;
            }
            for(int i = prevMax + 1; i <= max; i ++){
                result[i] = result[temp] + 1;
                queue.offer(i);
            }
        }
        return result[A.length - 1];
    }
}
