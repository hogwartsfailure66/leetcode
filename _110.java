public class _110 {
//    Balanced Binary Tree

    class Result {
        int height;
        boolean isBalanced;

        public Result() {
            height = 0;
            isBalanced = true;
        }

        public Result(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }

    /**
     * divide & conquer
     * bottom up
     * better
     */
    public boolean isBalanced(TreeNode root) {
        return getHeightAndBalance(root).isBalanced;
    }

    public Result getHeightAndBalance(TreeNode root) {
        if (root == null) {
            return new Result(0, true);
        }
        Result leftResult = getHeightAndBalance(root.left), rightResult = getHeightAndBalance(root.right);
        int height = Math.max(leftResult.height, rightResult.height) + 1;
        if (leftResult.isBalanced && rightResult.isBalanced && Math.abs(leftResult.height - rightResult.height) <= 1) {
            return new Result(height, true);
        }
        return new Result(height, false);
    }

    /**
     * dfs
     * top down
     */
    public boolean isBalanced1(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(getHeight1(root.left) - getHeight1(root.right)) > 1) {
            return false;
        }
        return isBalanced1(root.left) && isBalanced1(root.right);
    }

    public int getHeight1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return Math.max(getHeight1(root.left), getHeight1(root.right)) + 1;
    }
}
