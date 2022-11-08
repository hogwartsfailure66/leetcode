public class _1644 {
//    Lowest Common Ancestor of a Binary Tree II

    /**
     * my approach, same as my approach of 236
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
