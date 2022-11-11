import java.util.ArrayList;
import java.util.List;

public class _0017 {
//    Letter Combinations of a Phone Number

    char[][] lookupTable = {{}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
            {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return combinations;
        }
        constructCombination(digits, 0, new StringBuilder(), combinations);
        return combinations;
    }

    public void constructCombination(String digits, int index, StringBuilder combination, List<String> combinations) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
            return;
        }
        for (char c : lookupTable[digits.charAt(index) - '0']) {
            combination.append(c);
            constructCombination(digits, index + 1, combination, combinations);
            combination.delete(index, index + 1);
        }
    }
}
