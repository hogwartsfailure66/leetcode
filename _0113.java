import java.util.ArrayList;
import java.util.List;

public class _0113 {
//    Path Sum II

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, targetSum, result, new ArrayList<>());
        return result;
    }

    public void dfs(TreeNode root, int targetSum, List<List<Integer>> result, List<Integer> currentPath) {
        if (root == null) {
            return;
        }
        targetSum -= root.val;
        currentPath.add(root.val);
        if (targetSum == 0 && root.left == null && root.right == null) {
            result.add(new ArrayList<>(currentPath));
        }
        dfs(root.left, targetSum, result, currentPath);
        dfs(root.right, targetSum, result, currentPath);
        currentPath.remove(currentPath.size() - 1);
    }
}
