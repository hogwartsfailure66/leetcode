public class _215 {
//    Kth Largest Element in an Array

    /**
     * quick select
     */
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length) return -1;
        return partation(nums, 0, nums.length - 1, k);
    }

    public int partation(int[] nums, int start, int end, int k) {
        if (start == end) return nums[start];
        int pivot = nums[(start + end) / 2], left = start, right = end;
        while (left <= right) {
            while (left <= right && nums[left] > pivot) {
                left++;
            }
            while (left <= right && nums[right] < pivot) {
                right--;
            }
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        if (start + k  - 1 <= right) {
            return partation(nums, start, right, k);
        } else if (start + k - 1 >= left) {
            return partation(nums, left, end, k - left + start);
        } else {
            return pivot;
        }
    }
}
