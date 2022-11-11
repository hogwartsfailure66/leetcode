import java.util.ArrayList;
import java.util.List;

public class _0039 {
//    Combination Sum

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answers = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return answers;
        }
        enumerate(candidates, 0, target, new ArrayList<>(), answers);
        return answers;
    }

    public void enumerate(int[] candidates, int index, int target, List<Integer> current, List<List<Integer>> answers) {
        if (target == 0) {
            answers.add(new ArrayList<>(current));
            return;
        }
        if (index >= candidates.length || target < 0) {
            return;
        }
        current.add(candidates[index]);
        enumerate(candidates, index, target - candidates[index], current, answers);
        current.remove(current.size() - 1);
        enumerate(candidates, index + 1, target, current, answers);
    }

    public void backtrack(int[] candidates, int index, int target, List<Integer> current, List<List<Integer>> answers) {
        if (target == 0) {
            answers.add(new ArrayList<>(current));
            return;
        }
        if (index >= candidates.length || target < 0) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            current.add(candidates[i]);
            backtrack(candidates, i, target - candidates[i], current, answers);
            current.remove(current.size() - 1);
        }
    }
}
