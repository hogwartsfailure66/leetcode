public class _0700 {
//    Search in a Binary Search Tree

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (val < root.val) {
            return searchBST(root.left, val);
        }
        if (val == root.val) {
            return root;
        }
        return searchBST(root.right, val);
    }
}
