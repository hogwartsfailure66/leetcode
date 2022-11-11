package lintcode;

import java.util.ArrayList;
import java.util.List;

public class _0090 {
//    k Sum II

    /**
     * backtrack
     */
    public static List<List<Integer>> kSumII(int[] a, int k, int target) {
        List<List<Integer>> answers = new ArrayList<>();
        backtrack(a, k, 0, new ArrayList<>(), target, answers);
        return answers;
    }

    public static void backtrack(int[] a, int k, int index, List<Integer> current, int target, List<List<Integer>> answers) {
        if (target == 0 && k == 0){
            answers.add(new ArrayList<>(current));
            return;
        }
        if (index >= a.length || k < 0) {
            return;
        }
        for (int i = index; i < a.length; i++) {
            current.add(a[i]);
            backtrack(a, k - 1, i + 1, current, target - a[i], answers);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> answers = kSumII(new int[]{1, 2, 3, 4}, 2, 5);
        System.out.println(answers);
    }
}
