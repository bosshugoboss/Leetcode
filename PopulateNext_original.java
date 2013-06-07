public class Solution {
    public void connect(TreeLinkNode root) {
       
        if(root == null) return;
        TreeLinkNode parent = root;
        parent.next = null;
        while (parent.left != null) {

          TreeLinkNode tempParent = parent;
          boolean in = false;
          TreeLinkNode tempLast = tempParent.left;
        	while(tempParent != null) {
              if(!in) {
                  tempLast.next = tempParent.right;
                  tempParent = tempParent.next;
                 
              }else
                 tempLast.next = tempParent.left;
        	       tempLast = tempLast.next;
        	       in = !in;
        	     
        	   }
             tempLast.next = null;
        	   parent = parent.left;
        }
        
    }
}
