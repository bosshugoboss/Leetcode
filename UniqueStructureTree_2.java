public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        if(n == 0){
            ArrayList<TreeNode> result = new ArrayList<TreeNode>();
            TreeNode a = null;
            result.add(a);
            return result;
        }
        return generateTreeHelper(1, n);
    }
    
    public ArrayList<TreeNode> generateTreeHelper(int start, int end) {
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        if(start == end + 1) {
            return result;            
        }
        if(start == end) {
            TreeNode root = new TreeNode(end);
            root.left = null;
            root.right = null;
            result.add(root);
            return result;
        }
        for(int count = start; count <= end; count ++){
            
            ArrayList<TreeNode> leftNodes = generateTreeHelper(start, count - 1);
            ArrayList<TreeNode> rightNodes = generateTreeHelper(count + 1, end);
            if(leftNodes.size() == 0){
                for(TreeNode rightN : rightNodes){
                    TreeNode root = new TreeNode(count);
                    root.right = rightN;
                    root.left = null;
                    result.add(root);
                }
            }
            else if(rightNodes.size() == 0){
                for(TreeNode leftN : leftNodes){
                    TreeNode root = new TreeNode(count);
                    root.left = leftN;
                    root.right = null;
                    result.add(root);
                }
            }
            else{
              for(TreeNode leftN : leftNodes){
                for(TreeNode rightN : rightNodes){
                    TreeNode root = new TreeNode(count);
                    root.right = rightN;
                    root.left = leftN;
                    result.add(root);                 
                 }                
             }
            }
        }
        return result;
    }
}
