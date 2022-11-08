public class _0005 {
//    Longest Palindromic Substring

    public static String getLongestPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    public static String longestPalindrome(String s) {
        /**
         * DP
         */
        if (s == null || s.equals("")) return "";
        int start = 0, longest = 1;
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            isPalindrome[i][i] = true;
            if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                isPalindrome[i][i + 1] = true;
                start = i;
                longest = 2;
            }
        }
        for (int i = s.length() - 3; i >= 0; i--) {
            for (int j = i + 2; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && isPalindrome[i + 1][j - 1]) {
                    isPalindrome[i][j] = true;
                    if (j - i + 1 > longest) {
                        start = i;
                        longest = j - i + 1;
                    }
                }
            }
        }
        return s.substring(start, start + longest);
    }

        /**
         * 基于中心线的枚举算法 O(n^2)
         * 奇数，偶数=》重复代码=》子函数
         */
        public static String longestPalindrome1(String s) {
            if (s == null) return null;
            String result = "";
            for (int i = 0; i < s.length(); i++) {
                // odd length
                String currentLongest = getLongestPalindrome(s, i, i);
                if (currentLongest.length() > result.length()) {
                    result = currentLongest;
                }
                // even length
                currentLongest = getLongestPalindrome(s, i, i + 1);
                if (currentLongest.length() > result.length()) {
                    result = currentLongest;
                }
            }
            return result;
        }


        /***
         * Brute Force/Two Pointers TLE O(n^3)
         * 最优暴力：先for循环长度，再for循环起点、终点
         */
        public static String longestPalindrome2(String s) {
            if (s == null) return null;
            int length = s.length(), maxLength = 1, start = 0, end = 0;
            for (int i = 0; i < length - 1; i++) {
                for (int j = length - 1; j >= i + 1; j--) {
                    int leftPointer = i, rightPointer = j;
                    while (leftPointer < rightPointer) {
                        if (s.charAt(leftPointer) != s.codePointAt(rightPointer)) break;
                        leftPointer++;
                        rightPointer--;
                    }
                    if (leftPointer >= rightPointer && j - i + 1 > maxLength) {
                        maxLength = j - i + 1;
                        start = i;
                        end = j;
                    }
                }
            }
            return s.substring(start, end + 1);
        }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaaaa"));
    }
}
