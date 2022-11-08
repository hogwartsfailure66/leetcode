import java.util.HashSet;

public class _1650 {
//    Lowest Common Ancestor of a Binary Tree III

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }

    /**
     * O(1) space => count height of p & q first, do deeper one first till h1 = h2
     */

    /**
     * O(logn) time, O(logn) space
     */
    public Node lowestCommonAncestor(Node p, Node q) {
        HashSet<Node> ancestorsOfP = new HashSet<>();
        while (p != null) {
            ancestorsOfP.add(p);
            p = p.parent;
        }
        while (q != null) {
            if (ancestorsOfP.contains(q)) {
                return q;
            }
            q = q.parent;
        }
        return null;
    }
}
