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
    public int maxDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null) return 0;
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        map.put(root, 1);
        queue.offer(root);
        TreeNode temp = queue.poll();
        int result = 1;
        while(temp != null) {
            if(temp.left != null) {
                map.put(temp.left, map.get(temp) + 1);
                queue.offer(temp.left);
            }
            if(temp.right != null) {
                map.put(temp.right, map.get(temp) + 1);
                queue.offer(temp.right);
            }
            result = map.get(temp);
            temp = queue.poll();
            
        }
        return result;
    }
}
