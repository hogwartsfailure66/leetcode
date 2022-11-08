public class _509 {
//    Fibonacci Number

    /**
     * bottom-up generate
     */
    public int fib(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        int[] fibAns = new int[n + 1];
        fibAns[0] = 0;
        fibAns[1] = 1;
        for(int i = 2; i <= n; i++) {
            fibAns[i] = fibAns[i - 1] + fibAns[i - 2];
        }
        return fibAns[n];
    }

    /**
     * recursive & memorize
     */
    public int fib1(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        int[] fibAns = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            fibAns[i] = -1;
        }
        fibAns[0] = 0;
        fibAns[1] = 1;
        return calculateFib(n, fibAns);
    }

    public int calculateFib(int n, int[] fibAns) {
        if(fibAns[n] != -1) return fibAns[n];
        fibAns[n] = calculateFib(n - 1, fibAns) + calculateFib(n - 2, fibAns);
        return fibAns[n];
    }
}