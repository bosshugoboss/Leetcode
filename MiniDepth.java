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
    public int minDepth(TreeNode root) {
            // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null) return 0;
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        root.val = 1;
        queue.offer(root);      
        TreeNode temp = queue.poll();
        int tempDepth = 1;
        while(temp != null){
              if(temp.right == null && temp.left == null) return temp.val;
              else{
                if(temp.right != null) {
                 temp.right.val = temp.val + 1;
                 queue.offer(temp.right);
                 }
                if(temp.left != null) {
                 temp.left.val = temp.val + 1;                 
                 queue.offer(temp.left);
                }
              }
              tempDepth = temp.val;
              temp = queue.poll();
        }
        return tempDepth;
    }
}
