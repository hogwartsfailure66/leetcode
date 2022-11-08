public class _0088 {
//    Merge Sorted Array

    /**
     * two pointers, O(m+n) time, O(1) space
     * merge from right to start!!!
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pointer1 = m - 1, pointer2 = n - 1;
//        can be better
//        while (pointer1 >= 0 && pointer2 >= 0) {
//            if (nums1[pointer1] >= nums2[pointer2]) {
//                nums1[index--] = nums1[pointer1--];
//            } else {
//                nums1[index--] = nums2[pointer2--];
//            }
//        }
//        while (pointer1 >= 0) {
//            ...
//        }
//        while (pointer2 >= 0) {
//            ...
//        }
        for (int i = m + n - 1; i >= 0; i--) {
            if (pointer2 < 0) {
                break;
            }
            if (pointer1 >= 0 && nums1[pointer1] > nums2[pointer2]) {
                nums1[i] = nums1[pointer1--];
            } else {
                nums1[i] = nums2[pointer2--];
            }
        }
    }

    /**
     * two pointers, O(m+n) time, O(m+n) space
     * can be O(m) space if copy num1, not a new result array
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int pointer1 = 0, pointer2 = 0, index = 0, length = m + n;
        int[] result = new int[length];
        while (pointer1 < m && pointer2 < n) {
            if (nums1[pointer1] <= nums2[pointer2]) {
                result[index++] = nums1[pointer1++];
            } else {
                result[index++] = nums2[pointer2++];
            }
        }
        while (pointer1 < m) {
            result[index++] = nums1[pointer1++];
        }
        while (pointer2 < n) {
            result[index++] = nums2[pointer2++];
        }
        for (int i = 0; i < length; i++) {
            nums1[i] = result[i];
        }
    }
}
