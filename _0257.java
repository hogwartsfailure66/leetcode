import java.util.ArrayList;
import java.util.List;

public class _0257 {
//    Binary Tree Paths

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        if (root.left == null && root.right == null) {
            result.add(String.valueOf(root.val));
            return result;
        }
        StringBuilder currentPath = new StringBuilder();
        currentPath.append(root.val);
        dfs(root.left, currentPath, result);
        dfs(root.right, currentPath, result);
        return result;
    }

    public void dfs(TreeNode root, StringBuilder currentPath, List<String> result) {
        if (root == null) {
            return;
        }
        int index = currentPath.length() - 1;
        currentPath.append("->" + root.val);
        if (root.left == null && root.right == null) {
            result.add(currentPath.toString());
        }
        dfs(root.left, currentPath, result);
        dfs(root.right, currentPath, result);
        currentPath.delete(index, currentPath.length());
    }
}
