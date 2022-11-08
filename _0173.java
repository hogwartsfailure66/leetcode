import java.util.Stack;

public class _0173 {
//    Binary Search Tree Iterator

    class BSTIterator {
        Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            findLeftMost(root);
        }

        public int next() {
            if (hasNext()) {
                TreeNode current = stack.pop();
                findLeftMost(current.right);
                return current.val;
            }
            return -1;
        }

        public boolean hasNext() {
            return !stack.empty();
        }

        public void findLeftMost(TreeNode root) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }
    }

//    rubbish
//    class BSTIterator {
//        List<Integer> result = new ArrayList<>();
//        int size = 0;
//        int index = 0;
//
//        public BSTIterator(TreeNode root) {
//            if (root == null) {
//                return;
//            }
//            Stack<TreeNode> stack = new Stack<>();
//            while (root != null || !stack.empty()) {
//                while (root != null) {
//                    stack.push(root);
//                    root = root.left;
//                }
//                root = stack.pop();
//                result.add(root.val);
//                root = root.right;
//            }
//            this.size = result.size();
//        }
//
//        public int next() {
//            if (hasNext()) {
//                return result.get(index++);
//            }
//            return -1;
//        }
//
//        public boolean hasNext() {
//            return index <= size - 1;
//        }
//    }
}
