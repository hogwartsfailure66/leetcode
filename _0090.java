import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class _0090 {
//    Subsets II

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> answers = new ArrayList<>();
        HashMap<Integer, Integer> visited = new HashMap<>();
        if (nums == null) {
            return answers;
        }
        Arrays.sort(nums);
        backtrack(nums, 0, answers, new ArrayList<>());
        return answers;
    }

    public void backtrack(int[] nums, int start, List<List<Integer>> answers, List<Integer> current) {
        answers.add(new ArrayList<>(current));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {  // [1,2,2],相同的集合[1,2']和[1,2'']总是选第一个；遇到相同数且不是第一个，不选
                continue;
            }
            current.add(nums[i]);
            backtrack(nums, i + 1, answers, current);
            current.remove(current.size() - 1);
        }
    }
}
