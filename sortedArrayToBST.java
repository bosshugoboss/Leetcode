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
    public TreeNode sortedArrayToBST(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(num.length == 0) return null;
        TreeNode root = new TreeNode(0);
        sortedArrayRec(num, root, 0, num.length);
        return root;
    }
    
    public void sortedArrayRec(int[] num, TreeNode root, int start, int end){
        if(start >= end) return;
        if(start == end - 1){
            root.val = num[start];
        }
        else{
         int length = end - start;
         int leftLength = (int) Math.pow(2, log2(length) - 1);
         int lastLevel = (int) Math.pow(2, log2(length)) - 1;
         int rest = length - lastLevel;
         int index = 0;
         if(rest <= (lastLevel + 1)/2) index = length - leftLength;
         else index = length - leftLength - rest + (lastLevel + 1)/2;
         root.val = num[index];
         if(index > start){
             root.right = new TreeNode(0);
             sortedArrayRec(num, root.right, start, index);
         }
         if(index + 1 < end){
             root.left = new TreeNode(0);        
             sortedArrayRec(num, root.left, index + 1, end);
         }
       }
    }
    private int log2(int x){
        return (int)(Math.log(x)/Math.log(2));
    }
}
