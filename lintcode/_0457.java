package lintcode;

public class _0457 {
//    Classical Binary Search: Find any position of a target number in a sorted array. Return -1 if target does not exist.

    public int findPosition(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if (nums[start] == target) {
            return start;
        }
        return -1;
    }
}
