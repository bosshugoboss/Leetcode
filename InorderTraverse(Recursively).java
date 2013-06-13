public class Solution {
    
    private ArrayList<Integer> result;
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        result = new ArrayList<Integer>();
        inorderTraverseHelper(root);
        return result;
    }
    
    public void inorderTraverseHelper(TreeNode root) { 
        
        if(root == null) return;
        inorderTraverseHelper(root.left);
        result.add(root.val);
        inorderTraverseHelper(root.right);
    }
}
