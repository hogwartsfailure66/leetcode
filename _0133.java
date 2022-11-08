import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class _0133 {
//    Clone Graph

    /**
     * dfs or bfs
     * @param node
     * @return
     */
    public Node cloneGraph(Node node) {
        return bfs(node);
    }

    public static Node dfs(Node node, HashMap<Node, Node> hashMap) {
        if (node == null) {
            return null;
        }
        if (hashMap.containsKey(node)) {
            return hashMap.get(node);
        }
        Node current = new Node(node.val);
        hashMap.put(node, current);
        for (Node neighbor : node.neighbors) {
            current.neighbors.add(dfs(neighbor, hashMap));
        }
        return current;
    }

    public static Node bfs(Node node) {
        if (node == null) {
            return null;
        }
        HashMap<Node, Node> hashMap = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        hashMap.put(node, new Node(node.val));
        while (!queue.isEmpty()) {
            Node current = queue.poll(), replicate = hashMap.get(current);
            for (Node neighbor : current.neighbors) {
               Node neighborReplicate = getNode(neighbor, hashMap, queue);
               replicate.neighbors.add(neighborReplicate);
            }
        }
        return hashMap.get(node);
    }

    public static Node getNode(Node node, HashMap<Node, Node> hashMap, Queue<Node> queue) {
        Node result;
        if (hashMap.containsKey(node)) {
            result = hashMap.get(node);
        } else {
            result = new Node(node.val);
            hashMap.put(node, result);
            queue.add(node);
        }
        return result;
    }
}
