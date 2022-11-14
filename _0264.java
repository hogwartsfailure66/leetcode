import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class _0264 {
//    Ugly Number II

    public int nthUglyNumber(int n) {
        int[] uglyNumbers = new int[1690];
        uglyNumbers[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0, newUglyNumber = 0;
        for (int i = 1; i < n; i++) {
            newUglyNumber = Math.min(Math.min(uglyNumbers[i2] * 2, uglyNumbers[i3] * 3), uglyNumbers[i5] * 5);
            uglyNumbers[i] = newUglyNumber;
            if (newUglyNumber == uglyNumbers[i2] * 2) {
                i2++;
            }
            if (newUglyNumber == uglyNumbers[i3] * 3) {
                i3++;
            }
            if (newUglyNumber == uglyNumbers[i5] * 5) {
                i5++;
            }
        }
        return uglyNumbers[n - 1];
    }

    public int nthUglyNumber1(int n) {
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        set.add(1L);
        priorityQueue.add(1L);
        int[] factors = new int[]{2, 3, 5};
        long result = 0, newUglyNumber;
        for (int i = 0; i < n; i++) {
            result = priorityQueue.poll();
            for (int j = 0; j < 3; j++) {
                newUglyNumber = result * factors[j];
                if (set.contains(newUglyNumber)) {
                    continue;
                }
                set.add(newUglyNumber);
                priorityQueue.add(newUglyNumber);
            }
        }
        return (int) result;
    }
}
