public class _33 {
//    Search in Rotated Sorted Array

    /**
     * binary search O(logn)
     * One pass binary search -> find which half is not rotated
     * two pass binary search -> find smallest then search
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length - 1, mid = 0;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > nums[start]) { // first half not rotated
                if (nums[start] <= target && nums[mid] > target) { // start <= target < mid
                    end = mid;
                } else {
                    start = mid;
                }
            } else { // second half not rotated
                if (nums[mid] < target && nums[end] >= target) { // mid < target <= end
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }
}
