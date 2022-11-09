public class _1120 {
//    Maximum Average Subtree

    class Result {
        int sum;
        int size;
        double average;

        public Result(int sum, int size, double average) {
            this.sum = sum;
            this.size = size;
            this.average = average;
        }
    }

    public double maximumAverageSubtree(TreeNode root) {
        Result maximumResult = new Result(0, 0, 0.0);
        calculateSubtreeAvg(root, maximumResult);
        return maximumResult.average;
    }

    public Result calculateSubtreeAvg(TreeNode root, Result maximumResult) {
        if (root == null) {
            return new Result(0, 0, 0);
        }
        Result left = calculateSubtreeAvg(root.left, maximumResult);
        Result right = calculateSubtreeAvg(root.right, maximumResult);
        int totalSum = left.sum + right.sum + root.val, totalSize = left.size + right.size + 1;
        Result current = new Result(totalSum, totalSize, 1.0 * totalSum / totalSize);
        if (current.average > maximumResult.average) {
            maximumResult.average = current.average;
        }
        return current;
    }
}
