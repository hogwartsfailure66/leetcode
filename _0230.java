import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _0230 {
//    Kth Smallest Element in a BST

    /**
     * iterative
     */
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            k--;
            root = stack.pop();
            if (k == 0) {
                return root.val;
            }
            root = root.right;
        }
        return -1;
    }

    /**
     * recursive without global variables
     */
    public int kthSmallest1(TreeNode root, int k) {
        List<Integer> result = new ArrayList<>();
        traverse(root, result);
        return result.get(k - 1);
    }

    public void traverse(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        traverse(root.left, result);
        result.add(root.val);
        traverse(root.right, result);
    }

    /**
     * use global variables
     */
    public int count, answer = -1;

    public int kthSmallest2(TreeNode root, int k) {
        count = k;
        inorder(root);
        return answer;
    }

    public void inorder(TreeNode root) {
        if (root == null || count < 0) {
            return;
        }
        inorder(root.left);
        count--;
        if (count == 0) {
            answer = root.val;
            return;
        }
        inorder(root.right);
    }
}
