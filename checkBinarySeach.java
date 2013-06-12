public class Solution {
    
    boolean isvalid;
    int tempMax;
    public boolean isValidBST(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        isvalid = true;
        tempMax = Integer.MIN_VALUE;
        inorderValid(root);
        return isvalid;
    }


    public void inorderValid(TreeNode root){
        if(root == null) return;
        inorderValid(root.left);
        if(root.val > tempMax){
           tempMax = root.val;
        }
        else{
            isvalid = false;
        }
        inorderValid(root.right);
    }
}
