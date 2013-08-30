public int sumNumbers(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        sum = 0;
        sumNumbersRec(root, 0);
        return sum;
    }
    
    public void sumNumbersRec(TreeNode root, int prev){
        if(root.left == null && root.right == null){
            sum += prev * 10 + root.val;
        }
        else{
            if(root.left != null) sumNumbersRec(root.left, prev * 10 + root.val);
            if(root.right != null) sumNumbersRec(root.right, prev * 10 + root.val);
        }
        return; 
    }
