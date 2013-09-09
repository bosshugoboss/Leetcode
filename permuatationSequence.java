public class Solution {
    public String getPermutation(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        StringBuilder str = new StringBuilder();
        int num = k - 1;
        LinkedList<Integer> list = new LinkedList<Integer>();
        for(int i = 1; i <= n ; i++){
            list.add(i);
        }
        while(!list.isEmpty()){
            int numOfGroup = num / count(list.size() - 1);
            str.append(list.get(numOfGroup));
            list.remove(numOfGroup);
            num = num % count(list.size());
        }
        return str.toString();
    }
    
    private int count(int n){
        int result = 1;
        while(n > 1){
            result *= n--;
        }
        return result;
    }
}
