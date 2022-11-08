public class _0112 {
//    Path Sum

    /**
     * dfs, path sum can be negative!!!
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        targetSum -= root.val;
        if (targetSum == 0 && root.left == null && root.right == null) {
            return true;
        }
//        if (targetSum < 0) {
//            return false;
//        }
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }
}
