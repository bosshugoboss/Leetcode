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
   public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        LinkedList<ArrayList<Integer>> result = new LinkedList<ArrayList<Integer>>();
        Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        Queue<TreeNode> queue1 = new ArrayDeque<TreeNode>();
        if(root == null) return new ArrayList<ArrayList<Integer>>(result);
        queue.offer(root);
        map.put(root, 1);
        queue1.offer(root);
        TreeNode temp = queue.poll();
        while(temp != null){
             if(temp.left != null){
              queue.offer(temp.left);
            	map.put(temp.left, map.get(temp) + 1);
            	queue1.offer(temp.left);
            }
            if(temp.right != null){
                queue.offer(temp.right);
            	map.put(temp.right, map.get(temp) + 1);
            	queue1.offer(temp.right);
            } 
           
            temp = queue.poll();
        }

   
        ArrayList<Integer> subResult = new ArrayList<Integer>();
        temp = queue1.poll();
        int depth = map.get(temp);
        while(temp != null){
            if(depth == map.get(temp)){
               subResult.add(temp.val);
            }
            else{
            	depth = map.get(temp);
                result.addFirst(subResult);
                subResult = new ArrayList<Integer>();
                subResult.add(temp.val);
            }
            temp = queue1.poll();
        }
        result.addFirst(subResult);
        return new ArrayList<ArrayList<Integer>>(result); 
    }
}

/* new */
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        if(root == null) return result;
        queue.offer(root);
        map.put(root, 0);
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            int level = map.get(temp);
            if(level >= result.size()){
                ArrayList<Integer> newA = new ArrayList<Integer>();
                result.add(newA);
            }
               result.get(level).add(temp.val);
            if(temp.left != null){
                map.put(temp.left, level + 1);
                queue.offer(temp.left);
            }
            if(temp.right != null){
                map.put(temp.right, level + 1);
                queue.offer(temp.right);
            }
        }
        
        return result;
    }
}
