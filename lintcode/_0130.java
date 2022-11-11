package lintcode;

import java.util.Arrays;

public class _0130 {
//    Heapify

    /**
     * sb lintcode, testcase答案错了,搞得老子debug了半天
     */
    public static void heapify(int[] a) {
        if (a == null || a.length == 0) {
            return;
        }
        for (int i = (a.length - 2) / 2; i >= 0; i--) {
            min_heapify(a, i);
        }
    }

    public static void min_heapify(int[] a, int index) {
        int left = index * 2 + 1, right = index * 2 + 2;
        if (left >= a.length) {
            return;
        }
        int small = right >= a.length ? left : a[left] < a[right] ? left : right;
        if (a[index] > a[small]) {
            swap(a, small, index);
            min_heapify(a, small);
        }
    }

    public static void swap(int[] A, int a, int b) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }

    public static void main(String[] args) {
        int[] heap = new int[]{3, 2, 1, 4, 5};
        heapify(heap);
        System.out.println(Arrays.toString(heap));
    }
}
