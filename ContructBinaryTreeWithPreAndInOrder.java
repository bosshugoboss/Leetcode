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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(preorder.length == 0) return null;
        TreeNode root = new TreeNode(0);
        buildTreeRec(root, preorder, 0, preorder.length, inorder, 0, inorder.length);
        return root;
    }
    private void buildTreeRec(TreeNode root, int[] preorder, int startP, int endP, int[] inorder, int startI, int endI){
        if(startP == endP - 1){
            root.val = preorder[startP];
        }
        else{
            int rootValue = preorder[startP];
            root.val = rootValue;
            int index = findInorder(inorder, rootValue);
            int leftLength = index - startI; 
            int rightLength = endI - index - 1;
            
           
            if(leftLength > 0){
            root.left = new TreeNode(0);
            buildTreeRec(root.left, preorder, startP + 1, startP + 1 + leftLength ,inorder, startI, startI + leftLength);
            }
            if(rightLength > 0){
            root.right = new TreeNode(0);   
            buildTreeRec(root.right, preorder, endP - rightLength ,endP, inorder, endI - rightLength ,endI);
            }
        }
    }
    
    private int findInorder(int[] inorder, int rootValue){
        for(int i = 0; i < inorder.length; i ++){
            if(inorder[i] == rootValue) return i;
        }
        return 0;
    }
}
