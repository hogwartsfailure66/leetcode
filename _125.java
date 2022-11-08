public class _125 {
//    Valid Palindrome

    public static boolean isAlphanumeric(char c) {
//        return (c - 'a' >= 0 && 'z' - c >= 0) || (c - '0' >= 0 && '9' - c >= 0);
        return Character.isDigit(c) || Character.isLetter(c);
    }

    public static boolean isValid(char left, char right) {
        return Character.toLowerCase(left) == Character.toLowerCase(right);
    }

    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !isAlphanumeric(s.charAt(left))) {
                left++;
            }
            while (left < right && !isAlphanumeric(s.charAt(right))) {
                right--;
            }
            if (left < right && !isValid(s.charAt(left), s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * not good, 3 loop & O(n) space, can do it in 1 loop & O(1) space, Character.isLetter()/isDigit()/toLower(Upper)Case()
     * Approach 2: reverse and compare, O(n) time, O(n) space;
     */
    public boolean isPalindrome1(String s) {
        if(s == null || s.length() == 0) return true;
        s = s.toLowerCase();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(isAlphanumeric(s.charAt(i))) {
                stringBuilder.append(s.charAt(i));
            }
        }
        s = stringBuilder.toString();
        int left = 0, right = s.length() - 1;
        while(left <= right) {
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
