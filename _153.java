public class _153 {
//    Find Minimum in Rotated Sorted Array

    /**
     * binary search, O(logn)
     */
    public int findMin(int[] nums) {
//        no need
//        if (nums.length == 1) {
//            return nums[0];
//        }
        int left = 0, right = nums.length - 1, mid = 0;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return Math.min(nums[left], nums[right]);
    }
}
