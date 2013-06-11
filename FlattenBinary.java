public class Solution {
    public void flatten(TreeNode root) {
        
        if(root == null) return;
        flatten(root.left);
      flatten(root.right);
    	TreeNode left = root.left;
    	if(left != null){
         while(left.right != null){
    		left = left.right;
    	 }
      	 TreeNode right = root.right;     
         root.right = root.left;
         root.left = null;
         left.right = right;
       }
    }
}
