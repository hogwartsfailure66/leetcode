import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0047 {
//    Permutations II

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> answers = new ArrayList<>();
        if (nums == null) {
            return answers;
        }
        Arrays.sort(nums);
        backtrack(nums, new ArrayList<>(), answers, new boolean[nums.length]);
        return answers;
    }

    public void backtrack(int[] nums, List<Integer> current, List<List<Integer>> answers, boolean[] visited) {
        if (nums.length == current.size()) {
            answers.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || i > 0 && nums[i] == nums[i-1] && !visited[i - 1]) {
                continue;
            }
            current.add(nums[i]);
            visited[i] = true;
            backtrack(nums, current, answers, visited);
            visited[i] = false;
            current.remove(current.size() - 1);
        }
    }
}
