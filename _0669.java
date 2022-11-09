public class _0669 {
//    Trim a Binary Search Tree

    /**
     * When node.val > high, we know that the trimmed binary tree must occur to the left of the node.
     * Similarly, when node.val < low, the trimmed binary tree occurs to the right of the node.
     * Otherwise, we will trim both sides of the tree.
     */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val < low) return trimBST(root.right, low, high);
        if (root.val > high) return trimBST(root.left, low, high);

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }

    /**
     * not good
     */
    public TreeNode trimBST1(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        TreeNode left = trimBST1(root.left, low, high);
        TreeNode right = trimBST1(root.right, low, high);
        if (root.val < low || root.val > high) {
            if (left != null) {
                return left;
            }
            return right;
        }
        root.left = left;
        root.right = right;
        return root;
    }
}
