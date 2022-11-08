public class _680 {
//    Valid Palindrome II

    static class Pair {
        int left, right;
        public Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public Pair findDifference(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            left++;
            right--;
        }
        return new Pair(left, right);
    }

    public boolean isPalindrome(String s, int left, int right) {
        Pair result = findDifference(s, left, right);
        return result.left >= result.right;
    }

    public boolean validPalindrome(String s) {
        if (s == null) return false;
        if (s.length() == 0) return true;
        Pair result = findDifference(s, 0, s.length() - 1);
        if(result.left >= result.right) {
            return true;
        }
        return isPalindrome(s, result.left + 1, result.right) || isPalindrome(s, result.left, result.right - 1);
    }
}
