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

        int result = 0;
        if(root == null) return 0;
        int rightDepth = minDepth(root.right);
        int leftDepth = minDepth(root.left);
        if(leftDepth != 0)
         result = rightDepth == 0 ? leftDepth + 1 : Math.min(rightDepth, leftDepth) + 1;
        else
         result = leftDepth == 0? rightDepth + 1 : Math.min(rightDepth, leftDepth) + 1;
        return result;
    }
}
