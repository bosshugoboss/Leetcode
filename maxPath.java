public class Solution {
    public static int max = 0;
    public int maxPathSum(TreeNode root) {
           max = Integer.MIN_VALUE;
           maxPathRec(root);
           return max;
    }
    
    public int maxPathRec(TreeNode root) {
        if(root == null) return 0;
        int left = maxPathRec(root.left);
        int right = maxPathRec(root.right);
        int temp = root.val;
        if(left > 0) temp += left;
        if(right > 0) temp += right;
        if(temp > max) max = temp;
        int temp2 = root.val + Math.max(0, Math.max(left,right));
        return temp2;
    }
}
