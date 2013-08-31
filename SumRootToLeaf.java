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
    public static int sum;
    public int sumNumbers(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        sum = 0;
        sumNumbersRec(root, 0);
        return sum;
    }
    
    public void sumNumbersRec(TreeNode root, int prev){
        if(root == null) return;
        if(root.left == null && root.right == null){
            sum += prev * 10 + root.val;
        }
        else{
            if(root.left != null) sumNumbersRec(root.left, prev * 10 + root.val);
            if(root.right != null) sumNumbersRec(root.right, prev * 10 + root.val);
        }
        return; 
    }
}
