public class _702 {
//    Search in a Sorted Array of Unknown Size

    /**
     * 倍增找区间 + binary search
     */
    public int search(ArrayReader reader, int target) {
        int index = 0, num = reader.get(index);
        if (num == Integer.MAX_VALUE) {
            return -1;
        }
        if (num == target) {
            return index;
        }
        index = 1;
        num = reader.get(index);
        while (num < target) {
            index *= 2;
            num = reader.get(index);
        }
        if (num == target) {
            return index;
        }
        return binarySearch(reader, target, index / 2, index);
    }

    public static int binarySearch(ArrayReader reader, int target, int start, int end) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int num = reader.get(mid);
            if (target == num) {
                return mid;
            } else if (target < num) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (reader.get(start) == target) {
            return start;
        }
        if (reader.get(end) == target) {
            return end;
        }
        return -1;
    }
}
