/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(node == null) return null;
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        Queue<UndirectedGraphNode> copyQueue = new LinkedList<UndirectedGraphNode>();
        Set<Integer> set = new HashSet<Integer>();
        queue.offer(node);
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        copyQueue.offer(root);
        set.add(node.label);
        while(!queue.isEmpty()) {
            UndirectedGraphNode temp = queue.poll();
            UndirectedGraphNode copyTemp = copyQueue.poll();
            for(UndirectedGraphNode nod : temp.neighbors){
                UndirectedGraphNode copyTempNeighbour = new UndirectedGraphNode(nod.label);
                copyTemp.neighbors.add(copyTempNeighbour);
                if(!set.contains(copyTempNeighbour.label)){
                    set.add(copyTempNeighbour.label);
                    queue.offer(nod);
                    copyQueue.offer(copyTempNeighbour);
                }
            }
        }
        return root;
    }
}
