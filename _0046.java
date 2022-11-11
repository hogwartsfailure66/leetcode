import java.util.ArrayList;
import java.util.List;

public class _0046 {
//    Permutations

    /**
     * O(n*n!)
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answers = new ArrayList<>();
        if (nums == null) {
            return answers;
        }
        backtrack(nums, new ArrayList<>(), answers, new boolean[nums.length]);
        return answers;
    }

    public void backtrack(int[] nums, List<Integer> current, List<List<Integer>> answers, boolean[] visited) {
        if (nums.length == current.size()) {
            answers.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            current.add(nums[i]);
            backtrack(nums, current, answers, visited);
            visited[i] = false;
            current.remove(current.size() - 1);
        }
    }
}
