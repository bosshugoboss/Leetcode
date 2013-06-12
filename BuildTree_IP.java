
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Start typing your Java solution below
        // DO NOT write main() function       
        if(postorder.length == 0) return null;
        return buildTreeHelper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);        
    }

    


    public TreeNode buildTreeHelper(int[] inorder, int inStart,int inEnd, int[] postorder, int poStart, int poEnd) {
         
          int search = -1;
          for(int count = inStart; count <= inEnd; count ++){
             if(inorder[count] == postorder[poEnd]) search = count;
          }
          if(poEnd < poStart) return null;
          TreeNode root = new TreeNode(postorder[poEnd]);
          
          int leftLength = search - inStart;
          int leftinStart = inStart;
          int leftinEnd = search - 1;
          int rightinStart = search + 1;
          int rightinEnd = inEnd;
          int leftpoStart = poStart;
          int leftpoEnd = poStart +  leftLength - 1;
          int rightpoStart = leftpoEnd + 1;
          int rightpoEnd = poEnd - 1;
          TreeNode rightNode = buildTreeHelper(inorder, rightinStart, rightinEnd, postorder, rightpoStart, rightpoEnd);
          TreeNode leftNode = buildTreeHelper(inorder, leftinStart, leftinEnd, postorder, leftpoStart, leftpoEnd);
          root.left = leftNode;
          root.right = rightNode;
          return root;     
    }
}
