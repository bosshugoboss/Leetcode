/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null) return result;
        ArrayList<Integer> trans = new ArrayList<Integer>();
        pathSumRec(root, sum, 0, trans, result); 
        return result;
    }
    
    private void pathSumRec(TreeNode root, int sum, int temp, ArrayList<Integer> trans, ArrayList<ArrayList<Integer>> result){
        ArrayList<Integer> newArray = new ArrayList<Integer>(trans);
        newArray.add(root.val);
        if(root.right == null && root.left == null){
            if(temp + root.val == sum){                
                result.add(newArray);
            }
        }
        else{
            if(root.right != null)
              pathSumRec(root.right, sum, temp + root.val, newArray, result);
            if(root.left != null)
              pathSumRec(root.left, sum, temp + root.val, newArray, result);
        }
    }
}
