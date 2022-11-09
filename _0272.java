import java.util.ArrayList;
import java.util.List;

public class _0272 {
//    Closest Binary Search Tree Value II

    /**
     * brute force, inorder + binary search + two pointers
     */
    public static List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> result = new ArrayList<>(), inorderResult = new ArrayList<>();
        inorder(root, inorderResult);
        int left = binarySearch(inorderResult, target), right = left + 1, size = inorderResult.size();
        k--;
        result.add(inorderResult.get(left--));
        while (k > 0) {
            if (left < 0 || right < size && Math.abs(target - inorderResult.get(left)) > Math.abs(target - inorderResult.get(right))) {
                result.add(inorderResult.get(right++));
            } else {
                result.add(inorderResult.get(left--));
            }
            k--;
        }
        return result;
    }

    public static int binarySearch(List<Integer> inorderResult, double target) {
        int start = 0, end = inorderResult.size() - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (inorderResult.get(mid) < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (Math.abs(target - inorderResult.get(start)) < Math.abs(target - inorderResult.get(end))) {
            return start;
        }
        return end;
    }

    public static void inorder(TreeNode root, List<Integer> inorderResult) {
        if (root == null) {
            return;
        }
        inorder(root.left, inorderResult);
        inorderResult.add(root.val);
        inorder(root.right, inorderResult);
    }

    public static void main(String[] args) {
        System.out.println(closestKValues(new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(5)), 3.5, 2));
    }
}
