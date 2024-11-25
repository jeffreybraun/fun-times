package org.fun;

/**
 * Fibonacci sequence Calculations
 */
public class LastTwoForTheRoad {

    /**
     * Returns the Fibonacci Sequence value for the nth position.
     *
     * @param n position in the sequence to return
     * @return Fibonacci Sequence value
     */
    public static int fibonacciRecursion(int n) {
        return (n <= 2)
                ? 1
                : fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);
    }

    /**
     * Returns the Fibonacci Sequence value for the nth position.
     *
     * @param n position in the sequence to return
     * @return Fibonacci Sequence value
     */
    public static int fibonacciIteration(int n) {
        int result = 1;
        if (n > 2) {
            result = 2;
            int previous = 1;
            for (int i = 3; i < n; i++) {
                int cache = result;
                result = previous + result;
                previous = cache;
            }
        }
        return result;
    }

}
