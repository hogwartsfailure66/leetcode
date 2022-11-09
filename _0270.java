public class _0270 {
//    Closest Binary Search Tree Value

    /**
     * binary search, O(H) time
     * go left if target is smaller than current root value, and go right otherwise.
     * Choose the closest to target value at each step.
     */
    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            return -1;
        }
        double distance = Math.abs(target - root.val);
        int closest = root.val;
        while (root != null) {
            double currentDistance = Math.abs(target - root.val);
            if (currentDistance < distance) {
                distance = currentDistance;
                closest = root.val;
            }
            if (target < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return closest;
    }

    /**
     * inorder, o(k) time
     */

    /**
     * brute force dfs, O(n) time
     */
    class Result {
        double distance;
        int closest;

        public Result(double distance, int closest) {
            this.distance = distance;
            this.closest = closest;
        }
    }

    public int closestValue1(TreeNode root, double target) {
        Result result = new Result(Double.POSITIVE_INFINITY, -1);
        dfs(root, target, result);
        return result.closest;
    }

    public void dfs(TreeNode root, double target, Result result) {
        if (root == null) {
            return;
        }
        double distance = Math.abs(target - root.val);
        if (distance < result.distance) {
            result.distance = distance;
            result.closest = root.val;
        }
        dfs(root.left, target, result);
        dfs(root.right, target, result);
    }
}
