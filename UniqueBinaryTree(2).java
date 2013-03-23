/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        if(n == 0){
            result.add(null);
            return result;
        }
        result = generateTreesRec(1, n);
        return result;
    }
    
    public ArrayList<TreeNode> generateTreesRec(int start, int end){
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        if(start == end){
          TreeNode temp = new TreeNode(start);
          result.add(temp);
          return result;
        }
        
        for(int index = start; index <= end; index ++){
          ArrayList<TreeNode> left = index == start? null
                                   : generateTreesRec(start, index - 1);
          ArrayList<TreeNode> right = index == end? null
                                   : generateTreesRec(index + 1, end);
          if(left == null){
            
             for(TreeNode rightTN : right){
                 TreeNode temp = new TreeNode(index); 
                 temp.right = rightTN;
                 result.add(temp);
             }
          }
          else if(right == null){       
             for(TreeNode leftTN : left){
                 TreeNode temp = new TreeNode(index);
                 temp.left = leftTN;
                 result.add(temp);
             }
          } 
          
          else{
              
              for(TreeNode leftTN : left)
                for(TreeNode rightTN : right){
                    TreeNode temp = new TreeNode(index);
                    temp.right = rightTN;
                    temp.left = leftTN;
                    result.add(temp);
              }
          }
        }
        
        return result;
    }
}
