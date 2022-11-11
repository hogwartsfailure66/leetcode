import java.util.ArrayList;
import java.util.List;

public class _0078 {
//    Subsets

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answers = new ArrayList<>();
        backtrack(nums, 0, answers, new ArrayList<>());
        return answers;
    }

    /**
     * backtrack
     */
    public void backtrack(int[] nums, int start, List<List<Integer>> answers, List<Integer> current) {
        answers.add(new ArrayList<>(current));
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(nums, i + 1, answers, current);
            current.remove(current.size() - 1);
        }
    }

    /**
     * dfs
     */
    public void generate(int[] nums, List<Integer> current, List<List<Integer>> answers, int index) {
        if (index >= nums.length) {
            answers.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[index]);
        generate(nums, current, answers, index + 1);
        current.remove(current.size() - 1);
        generate(nums, current, answers, index + 1);
    }
}
