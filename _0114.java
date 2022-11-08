import java.util.Stack;

public class _0114 {
//    Flatten Binary Tree to Linked List

    public void flatten(TreeNode root) {
        flattenAndReturnLast(root);
    }

    /**
     * recursion
     */
    public TreeNode flattenAndReturnLast(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftLast = flattenAndReturnLast(root.left), rightLast = flattenAndReturnLast(root.right);
        if (leftLast != null) {
            leftLast.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        return rightLast == null ? (leftLast == null ? root : leftLast) : rightLast;
    }

    /**
     * iteration with stack, O(n) space
     */
    public void flatten1(TreeNode root) {
        if (root == null) return;
        TreeNode current;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            current = stack.pop();
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
            current.left = null;
            current.right = stack.empty() ? null : stack.peek();
        }
    }
}
