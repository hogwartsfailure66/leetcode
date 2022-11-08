import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _0102 {
//    Binary Tree Level Order Traversal
//    Input: root = [3,9,20,null,null,15,7]
//    Output: [[3],[9,20],[15,7]]


    /**
     * use level size
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            result.add(new ArrayList<>());
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                result.get(level).add(node.val);
            }
            level++;
        }
        return result;
    }

    /**
     * dummy node, O(n) time, O(n) space
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(new TreeNode(-1001));
        ArrayList<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val == -1001) { // dummy node;
                result.add(list);
                list = new ArrayList<>();
                if (!queue.isEmpty()) {
                    queue.add(new TreeNode(-1001));
                }
                continue;
            }
            list.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return result;
    }
}
