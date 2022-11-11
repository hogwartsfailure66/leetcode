import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0040 {
//    Combination Sum II

    /**
     * backtrack
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> answers = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return answers;
        }
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), answers);
        return answers;
    }

    public void backtrack(int[] candidates, int target, int index, List<Integer> current, List<List<Integer>> answers) {
        if (target == 0) {
            answers.add(new ArrayList<>(current));
            return;
        }
        if (target < 0 || index >= candidates.length) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            current.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, current, answers);
            current.remove(current.size() - 1);
        }
    }
}
