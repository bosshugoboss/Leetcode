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
        // Start typing your Java solution below
        // DO NOT write main() function
        return (inordertraverse(root).equals(revordertraverse(root)));
    }
    
    public String inordertraverse(TreeNode root){
           StringBuffer result = new StringBuffer();
           inordertraverseRec(root, result);
           return result.toString();
    }
    
    public void inordertraverseRec(TreeNode node, StringBuffer result){
           TreeNode current = node;
           if(node == null) return;
           inordertraverseRec(node.left, result);
           result.append(node.val + "");
           inordertraverseRec(node.right, result);
    }
    
   public String revordertraverse(TreeNode root){
           StringBuffer result = new StringBuffer();
           revordertraverseRec(root, result);
           return result.toString();
    }
    
   public void revordertraverseRec(TreeNode node, StringBuffer result){
           TreeNode current = node;
           if(node == null) return;
           revordertraverseRec(node.right, result);
           result.append(node.val + "");
           revordertraverseRec(node.left, result);
    }
}
