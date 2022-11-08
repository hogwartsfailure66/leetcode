package lintcode;

public class _585 {
//    Maximum Number in Mountain Sequence

    /**
     * sb了,直接binary search即可
     * beat 67.2%
     */
    public int mountainSequence(int[] nums) {
        int start = 0, end = nums.length - 1, mid = 0;
        while (start < end) {
            mid = start + (end - start) / 2;
            if (mid == 0 || nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return nums[mid];
            } else if (nums[mid] < nums[mid - 1]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return nums[start];
    }

    /**
     * loop // two pointers O(n)
     * only beat 38.2%
     */
    public int mountainSequence1(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            if (nums[start + 1] > nums[start]) {
                start++;
            } else {
                return nums[start];
            }
            if (nums[end] < nums[end - 1]) {
                end--;
            } else {
                return nums[end];
            }
        }
        return nums[start];
    }
}
