import java.util.ArrayList;
import java.util.List;

public class _0098 {
//    Validate Binary Search Tree

    /**
     * valid range recursive
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isValidRange(root.left, Long.MIN_VALUE, root.val) && isValidRange(root.right, root.val, Long.MAX_VALUE);
    }

    public boolean isValidRange(TreeNode root, long low, long high) {
        if (root == null) {
            return true;
        }
        if (root.val < high && root.val > low) {
            return isValidRange(root.left, low, root.val) && isValidRange(root.right, root.val, high);
        }
        return false;
    }

    /**
     * inorder recursive traversal
     */
    static boolean isValid = true;

    public static boolean isValidBST2(TreeNode root) {
        inorder(root, new ArrayList<>());
        return isValid;
    }

    public static void inorder(TreeNode root, List<Integer> traversal) {
        if (!isValid || root == null) {
            return;
        }
        inorder(root.left, traversal);
        if (!isValid) {
            return;
        }
        int size = traversal.size();
        if (size != 0) {
            isValid = traversal.get(size - 1) < root.val;
            if (!isValid) {
                return;
            }
        }
        System.out.println(root.val);
        traversal.add(root.val);
        inorder(root.right, traversal);
    }

    /**
     * ugly
     */
    static class Result {
        int smallest;
        int largest;
        boolean isValid;
        boolean isEmpty;

        public Result(int smallest, int largest, boolean isValid, boolean isEmpty) {
            this.smallest = smallest;
            this.largest = largest;
            this.isValid = isValid;
            this.isEmpty = isEmpty;
        }

        public void print() {
            System.out.println("small:" + smallest + ",large:" + largest +",isvalid:" + isValid + ",isEmpty:" + isEmpty);
        }
    }

    public static boolean isValidBST1(TreeNode root) {
        return isValid1(root).isValid;
    }

    public static Result isValid1(TreeNode root) {
        if (root == null) {
            return new Result(0, 0, true, true);
        }
        if (root.left == null && root.right == null) {
            return new Result(root.val, root.val, true, false);
        }
        Result leftResult = isValid1(root.left), rightResult = isValid1(root.right);
        boolean rootLeftValid = leftResult.isEmpty || leftResult.largest < root.val && leftResult.smallest < root.val;
        boolean rootRightValid = rightResult.isEmpty || root.val < rightResult.smallest && root.val < rightResult.largest;
        int largest = leftResult.isEmpty ? root.val : Math.min(Math.min(root.val, leftResult.largest), leftResult.smallest);
        int smallest = rightResult.isEmpty ? root.val : Math.max(Math.max(root.val, rightResult.smallest), rightResult.largest);
//        System.out.println("current node" + root.val);
//        System.out.println("left Result");
//        leftResult.print();
//        System.out.println("right Result");
//        rightResult.print();
//        System.out.println("rlvalid:" + rootLeftValid + ",rrvalid:" + rootRightValid);
//        System.out.println("largest:" + largest + ",smallest" + smallest);
        return new Result(smallest, largest, leftResult.isValid && rightResult.isValid && rootLeftValid
                && rootRightValid, false);
    }

    public static void main(String[] args) {
        System.out.println(isValidBST2(new TreeNode(5, new TreeNode(4), new TreeNode(6, new TreeNode(3), new TreeNode(7)))));
    }
}
