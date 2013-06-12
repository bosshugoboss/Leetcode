public class Solution {

    TreeNode firstNode, secondNode, tempMaxNode; 
    int max ;
    public void recoverTree(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        firstNode = null; secondNode = null; tempMaxNode = null;  
        max = Integer.MIN_VALUE;
        getFirstNode(root);
        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;
    }

    public void getFirstNode(TreeNode root) {
         if(root == null) return;
         getFirstNode(root.left);
         if(root.val >= max) {
         	max = root.val;          
            tempMaxNode = root;
         }
         else{
            firstNode =  (firstNode == null) ? tempMaxNode : firstNode;
            secondNode = root;
         }
         getFirstNode(root.right);
    }
}
