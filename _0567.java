import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0567 {
//    Permutation in String
    /**
     * array map & sliding window!!!
     */
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() > s2.length()) {
            return false;
        }
        int[] s1map = new int[26], s2map = new int[26];
        int s1length = s1.length(), s2length = s2.length(), length = s2length - s1length;
        for (int i = 0; i < s1length; i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a'] ++;
        }
        if (matches(s1map, s2map)) {
            return true;
        }
        for (int i = 0; i < length; i++) {
            s2map[s2.charAt(i + s1length) - 'a']++;
            s2map[s2.charAt(i) - 'a']--;
            if (matches(s1map, s2map)) {
                return true;
            }
        }
        return false;
    }

    /**
     * use array as a map
     * 跟hashmap、sorting原理一样
     * 快很多
     */
    public boolean checkInclusion3(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] s1map = new int[26];
        for (int i = 0; i < s1.length(); i++)
            s1map[s1.charAt(i) - 'a']++;
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            int[] s2map = new int[26];
            for (int j = 0; j < s1.length(); j++) {
                s2map[s2.charAt(i + j) - 'a']++;
            }
            if (matches(s1map, s2map))
                return true;
        }
        return false;
    }

    public boolean matches(int[] s1map, int[] s2map) {
        for (int i = 0; i < 26; i++) {
            if (s1map[i] != s2map[i])
                return false;
        }
        return true;
    }

    /**
     * one string will be a permutation of another string only if both of them contain the same characters the same number of times.
     * O(m*nlogn)
     * or hashmap
     * both very slow...
     */
    public boolean checkInclusion2(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        int length = s2.length() - s1.length(), lengthOfs1 = s1.length();
        for (int i = 0; i <= length; i++) {
            if (sort(s1).equals(sort(s2.substring(i, i + lengthOfs1)))) {
                return true;
            }
        }
        return false;
    }

    public String sort(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

    /**
     * brute force, enumerate all possibilities, TLE
     */
    public boolean checkInclusion1(String s1, String s2) {
        if (s1 == null || s2 == null || s2.length() < s1.length()) {
            return false;
        }
        List<String> permutations = new ArrayList<>();
        int length = s1.length();
        backtrack(s1, "", permutations, new boolean[length], length);
        for (String s : permutations) {
            if (s2.contains(s)) {
                return true;
            }
        }
        return false;
    }

    public void backtrack(String s1, String current, List<String> permutations, boolean[] visited, int length) {
        if (current.length() == s1.length()) {
            permutations.add(current);
        }
        for (int i = 0; i < length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            backtrack(s1, current + s1.charAt(i), permutations, visited, length);
            visited[i] = false;
        }
    }
}
