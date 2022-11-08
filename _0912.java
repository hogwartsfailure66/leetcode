public class _0912 {
//    Sort Array

    public static int[] sortArray(int[] nums) {
        if (nums == null) return null;
        mergeSort(nums, 0, nums.length - 1, new int[nums.length]);
        return nums;
    }

    /**
     * merge sort, O(nlogn) time, O(n) space;
     */
    public static void mergeSort(int[] nums, int start, int end, int[] result) {
        if (start >= end) return;
        int mid = (start + end) / 2;
        mergeSort(nums, start, mid, result);
        mergeSort(nums, mid + 1, end, result);
        merge(nums, start, mid, end, result);
    }

    public static void merge(int[] nums, int start, int mid, int end, int[] result) {
        int left = start, right = mid + 1, index = start;
        while (left <= mid && right <= end) {
            if (nums[left] < nums[right]) {
                result[index++] = nums[left++];
            } else {
                result[index++] = nums[right++];
            }
        }
        while (left <= mid) {
            result[index++] = nums[left++];
        }
        while (right <= end) {
            result[index++] = nums[right++];
        }
        for (int i = start; i <= end; i++) {
            nums[i] = result[i];
        }
    }

    /**
     * quick sort, worst case O(n^2) time, O(1) space;
     */
    public static void partition(int[] array, int start, int end) {
        if (start >= end) return;
        int left = start, right = end, pivot = array[(start + end) / 2];
        while (left <= right) {
            while (left <= right && array[left] < pivot) { // 不用<=或>=pivot：保证遇到一串相同数字的时候能均分，eg：11..11 => 避免出现11..11 || ,而是1..1||1...1
                left++;
            }
            while (left <= right && array[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = array[right];
                array[right] = array[left];
                array[left] = temp;
                left++;
                right--;
            }
        }
        partition(array, start, right);
        partition(array, left, end);
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 7, 4, 5, 3, 2, 9, 1, 0, 3, 4};
        sortArray(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
