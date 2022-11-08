public class _0162 {
//    Find Peak Element

    /**
     * both sides increasing, must have a peak
     * both sides decreasing, may have a peak
     * one sides increasing, one side decreasing, may have a peak
     * -> find both sides increasing
     */
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length - 1, mid;
//        没必要
//        if (nums.length == 1) {
//            return 0;
//        }
//        if (nums.length == 2) {
//            return nums[0] > nums[1] ? 0 : 1;
//        }
//        if (nums[start] > nums[start + 1]) {
//            return start;
//        }
//        if (nums[end] > nums[end - 1]) {
//            return end;
//        }
//        while (start + 1 < end) {
//            mid = start + (end - start) / 2;
//            if (nums[mid] > nums[mid] + 1 || nums[mid] > nums[mid - 1]) {
//                start = mid;
//            } else {
//                end = mid;
//            }
//        }
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] < nums[mid - 1]) {
                end = mid;
            } else if (nums[mid] < nums[mid + 1]) {
                start = mid;
            } else {
                return mid;
            }
        }
        return nums[start] > nums[end] ? start : end;
    }
}
