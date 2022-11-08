import java.util.LinkedList;
import java.util.Queue;

public class _100 {
//    Same Tree

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return bfs(p, q);
    }

    /**
     * bfs, O(n)
     */
    public static boolean bfs(TreeNode p, TreeNode q) {
        Queue<TreeNode> pQueue = new LinkedList<>(), qQueue = new LinkedList<>();
        pQueue.add(p);
        qQueue.add(q);
        while (!pQueue.isEmpty() && !qQueue.isEmpty()) {
            TreeNode p1 = pQueue.poll(), q1 = qQueue.poll();
            if (p1 == null && q1 == null) {
                continue;
            }
            if (p1 == null || q1 == null) {
                return false;
            }
            if (p1.val != q1.val) {
                return false;
            }
            pQueue.add(p1.left);
            pQueue.add(p1.right);
            qQueue.add(q1.left);
            qQueue.add(q1.right);
        }
        return pQueue.isEmpty() && qQueue.isEmpty();
    }

    /**
     * dfs, O(n)
     */
    public static boolean dfs(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return dfs(p.left, q.left) && dfs(p.right, q.right);
    }
}
