public class _236 {
//    Lowest Common Ancestor of a Binary Tree

    /**
     * if there is parent pointer => backtrack from p & q & hashSet
     */

    /**
     * 妙啊, 左右不为空，就是root；一边为空，答案就是另一边
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q), right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right !=null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }
        return null;
    }

    /**
     * 复杂了，小丑竟是我自己
     */
    class Result {
        boolean isAncestorOfP;
        boolean isAncestorOfQ;
        TreeNode answer;

        public Result() {
            isAncestorOfP = false;
            isAncestorOfQ = false;
            this.answer = null;
        }

        public Result(boolean isAncestorOfP, boolean isAncestorOfQ, TreeNode answer) {
            this.isAncestorOfP = isAncestorOfP;
            this.isAncestorOfQ = isAncestorOfQ;
            this.answer = answer;
        }
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        Result result = isAncestor(root, p, q);
        return result.answer;
    }

    public Result isAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return new Result(false, false, null);
        }
        Result leftResult = isAncestor(root.left, p, q), rightResult = isAncestor(root.right, p, q);
        if (leftResult.isAncestorOfQ && leftResult.isAncestorOfP) {
            return leftResult;
        }
        if (rightResult.isAncestorOfQ && rightResult.isAncestorOfP) {
            return rightResult;
        }
        boolean isAncestorOfP = leftResult.isAncestorOfP || rightResult.isAncestorOfP || root.val == p.val,
                isAncestorOfQ = leftResult.isAncestorOfQ || rightResult.isAncestorOfQ || root.val == q.val;
        TreeNode answer = isAncestorOfQ && isAncestorOfP ? root : null;
        return new Result(isAncestorOfP, isAncestorOfQ, answer);
    }
}
