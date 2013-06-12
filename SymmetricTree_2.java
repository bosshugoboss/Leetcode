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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isEqual(root.left, root.right);
    }
    
    public boolean isEqual(TreeNode root1, TreeNode root2) {
        
        if(root1 == null && root2 == null) return true;
        if(root1 == null) return false;
        if(root2 == null) return false;
        if(root1.val != root2.val) return false;
        return isEqual(root1.left, root2.right) && isEqual(root1.right, root2.left);
    }
}
