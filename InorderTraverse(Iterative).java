
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
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
          
          ArrayList<Integer> result = new ArrayList<Integer>();
          if(root == null) return result;
          Stack<TreeNode> stack = new Stack<TreeNode>();
          HashSet<TreeNode> record = new HashSet<TreeNode>();
          stack.push(root);
          while(!stack.isEmpty()){
                TreeNode current = stack.peek();
                if(current.left != null && !record.contains(current.left)){
                   stack.push(current.left);
                   record.add(current.left);
                }
                else if(current.right != null){
                   record.add(current);
                   result.add(stack.pop().val);                   
                   if(!record.contains(current.right))
                    stack.push(current.right);
                }
                else{
                   result.add(stack.pop().val);
                }
          }       
          return result;
    }
}
