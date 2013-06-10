public class Solution {
    public void connect(TreeLinkNode root) {
       
        if(root == null) return;
        root.next = null;
        TreeLinkNode parent = root;
        TreeLinkNode tempParent = getNextAvailable(parent);  
        TreeLinkNode available = tempParent;
        boolean firstNode = true;
        while (available != null ) {
            tempParent = available;
          TreeLinkNode tempLast = tempParent.left == null ? tempParent.right : tempParent.left;
        	
        	while(tempParent != null) {
               
                   if(firstNode){
                   	  if(tempLast == tempParent.left) {
                   	  	 if(tempParent.right != null) {
                   	  	 	 tempLast.next = tempParent.right;
                             tempLast = tempLast.next;
                   	  	 }
                   	  }
                   	  firstNode = false;
                   }

                   else{
                   	  if(tempParent.left != null){
                   	  	 tempLast.next = tempParent.left;
                   	  	 tempLast = tempLast.next;
                   	  	 if(tempParent.right != null){
                            tempLast.next = tempParent.right;
                            tempLast = tempLast.next;
                   	  	 }
                   	  }
                   	  else{
                   	  	 tempLast.next = tempParent.right;
                   	  	 tempLast = tempLast.next;
                   	  }
                  }
                
        	     tempParent = getNextAvailable(tempParent.next);     
        	}
        	firstNode = true;
            if(tempLast != null)
               tempLast.next = null;
            available = available.left == null ? available.right : available.left;
            available = getNextAvailable(available);
        }
        
    }

    public TreeLinkNode getNextAvailable(TreeLinkNode root) {
           TreeLinkNode temp = root;
           while(temp != null) {
           	   if(temp.left != null || temp.right != null){
           	   	  return temp;
           	   }
           	   temp = temp.next;
           }

           return null;
    }
}
