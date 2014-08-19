/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        HashMap<UndirectedGraphNode, UndirectedGraphNode> copied =
            new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

        clone_bfs(node, copied);
        return copied.get(node);
    }

    private UndirectedGraphNode clone_dfs(UndirectedGraphNode node, 
        HashMap<UndirectedGraphNode, UndirectedGraphNode> copied)
    {
        if (copied.containsKey(node))
            return copied.get(node);
        UndirectedGraphNode new_node = new UndirectedGraphNode(node.label);
        copied.put(node, new_node);
        for (UndirectedGraphNode nr : node.neighbors) {
            copied.get(node).neighbors.add(clone_dfs(nr, copied));
        }

        return new_node;
    }

    private void clone_bfs(UndirectedGraphNode node, 
        HashMap<UndirectedGraphNode, UndirectedGraphNode> copied)
    {
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        UndirectedGraphNode new_node = new UndirectedGraphNode(node.label);
        copied.put(node, new_node);
        queue.add(node);

        while (!queue.isEmpty()) {
            UndirectedGraphNode nd = queue.poll();
            for (UndirectedGraphNode nr : nd.neighbors) {
                if (copied.containsKey(nr)) {
                    // if node already copied, put its clone into copied neigbor 
                    copied.get(nd).neighbors.add(copied.get(nr));
                } else {
                    // if not copied yet, create new and put new node to neigbor
                    new_node = new UndirectedGraphNode(nr.label);
                    copied.put(nr, new_node);
                    copied.get(nd).neighbors.add(new_node);
                    queue.add(nr);
                }
            }
        }
    }
}