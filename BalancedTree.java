public class Solution {
    public boolean isBalanced(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
          int result = isBalancedHelper(root);
          return result == -1? false : true;
    }

  public int isBalancedHelper(TreeNode root) {

        int depth = 0;
      if(root == null) return depth;
    	int leftResult = isBalancedHelper(root.left);
    	int rightResult = isBalancedHelper(root.right);
    	if(leftResult - 1 > rightResult || rightResult - 1 > leftResult || leftResult == -1 || rightResult == -1) {
    		depth = -1;
    	}
    	else{
    		depth = Math.max(leftResult, rightResult) + 1;
    	}
    	return depth;
    }

}
