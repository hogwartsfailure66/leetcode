package lintcode;

public class _183 {
//    Wood Cut

    /**
     * binary search
     */
    public static int woodCut(int[] l, int k) {
        int maxLength = 0;
        for (int length : l) {
            maxLength = Math.max(maxLength, length);
        }
        int start = 1, end = maxLength, mid = 0;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            int num = count(l, mid);
            if (num < k) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (count(l, end) >= k) {
            return end;
        }
        if (count(l, start) >= k) {
            return start;
        }
        return 0;
    }

    public static int count(int[] l, int length) {
        int num = 0;
        for (int len : l) {
            num += len / length;
        }
        return num;
    }

    public static void main(String[] args) {
        int[] l = {4, 5, 4, 5, 4, 5, 4, 5};
        System.out.println(woodCut(l, 36));
    }
}
