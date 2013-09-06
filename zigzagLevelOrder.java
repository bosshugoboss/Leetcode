public class Solution {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
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
            if(level % 2 == 0){
               result.get(level).add(temp.val);
            }
            else{
               result.get(level).add(0, temp.val);
            }
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
