import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _0103 {
//    Binary Tree Zigzag Level Order Traversal
//    Input: root = [3,9,20,null,null,15,7]
//    Output: [[3],[20,9],[15,7]]

    public static void dfs(TreeNode root, int level, List<List<Integer>> list) {
        if (root == null) {
            return;
        }
        if (level > list.size() - 1) {
            list.add(new ArrayList<>());
        }
        if (level % 2 == 0) {
            list.get(level).add(root.val);
        } else {
            list.get(level).add(0, root.val);
        }
        if (root.left != null) {
            dfs(root.left, level + 1, list);
        }
        if (root.right != null) {
            dfs(root.right, level + 1, list);
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    /**
     * bfs, O(n)
     */
    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        boolean flag = true; // left to right: true
        int size, level = 0;
        deque.addFirst(root);
        while (!deque.isEmpty()) {
            TreeNode node;
            result.add(new ArrayList<>());
            size = deque.size();
            for (int i = 0; i < size; i++) {
                if (flag) {
                    node = deque.pollFirst();
                    if (node.left != null) {
                        deque.addLast(node.left);
                    }
                    if (node.right != null) {
                        deque.addLast(node.right);
                    }
                } else {
                    node = deque.pollLast();
                    if (node.right != null) {
                        deque.addFirst(node.right);
                    }
                    if (node.left != null) {
                        deque.addFirst(node.left);
                    }
                }
                result.get(level).add(node.val);
            }
            flag = !flag;
            level++;
        }
        return result;
    }
}
