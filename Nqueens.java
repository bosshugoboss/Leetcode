public class Solution {
    public ArrayList<String[]> solveNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String[]> result = new ArrayList<String[]>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        solveQueenRec(n, path, result);
        return result;
    }
    
    private void solveQueenRec(int n, ArrayList<Integer> path, ArrayList<String[]> result){
        if(path.size() == n){
            String[] tempR = new String[n];
            int position = 0;
            for(Integer i : path){
                StringBuilder str = new StringBuilder();
                for(int j = 0; j < n; j ++){
                    if(j != i) str.append('.');
                    else str.append('Q');
                }
                tempR[position ++] = str.toString();
            }
            result.add(tempR);
        }
        else{
            int row = path.size();
            for(int i = 0; i < n; i ++){
                if(check(row, i, path)){
                    path.add(i);
                    solveQueenRec(n, path, result);
                    path.remove(path.size() - 1);
                }
            }
        }
    }
    
    private boolean check(int row, int column, ArrayList<Integer> path){
        int position = 0;
        for(Integer i : path){
            if(column == i || Math.abs(i-column) == Math.abs(position-row)) return false;
            position ++;
        }
        return true;
    }
}
