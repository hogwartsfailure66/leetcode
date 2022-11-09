public class _0108 {
//    Convert Sorted Array to Binary Search Tree

    public TreeNode sortedArrayToBST(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }

    public TreeNode construct(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        TreeNode left = construct(nums, start, mid - 1);
        TreeNode right = construct(nums, mid + 1, end);
        root.left = left;
        root.right = right;
        return root;
    }
}
