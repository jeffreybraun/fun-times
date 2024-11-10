package org.fun;

import lombok.NonNull;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * A fun experiment with circular queuing.
 * No real practical purpose. Just having fun.
 */
public class RoundRobin {

    public static void main(String[] args) {
        var counts = roundNRound(1000, "a", "b", "c");
        counts.forEach(
                (k, v) -> System.out.println(k + " " + v)
        );
    }

    /**
     * Performs the Round-n-Round Fun activities!
     *
     * @param times Number of iterations through the circular queue.
     * @param items Objects to tbe round-n-rounded, eventually being counted.
     * @return Map of the objects supplied with their round-n-round counts.
     */
    @SafeVarargs
    public static <T> Map<T, AtomicInteger> roundNRound(int times, T... items) {
        ConcurrentMap<T, AtomicInteger> counts = new ConcurrentHashMap<>();
        CircularQueue circularQueue = new CircularQueue(items);
        if (times > 0) {
            IntStream.range(0, times)
                    .parallel()
                    .forEach(i -> countItem(circularQueue, counts));
        }
        return counts;
    }

    /**
     * Updates the counts of the CircularQueue returned items.
     *
     * @param circularQueue Round-robin source data.
     */
    protected static <T> void countItem(@NonNull CircularQueue circularQueue, ConcurrentMap<T, AtomicInteger> counts) {
        var item = (T) circularQueue.get();
        counts.putIfAbsent(item, new AtomicInteger(0));
        counts.get(item).incrementAndGet();
    }

    /**
     * Local CircularQueue to hande the round-robin operations.
     */
    protected static class CircularQueue {
        private final Object[] items;
        private int next = 0;

        @SafeVarargs
        public <T> CircularQueue(T... items) {
            this.items = items;
        }

        /**
         * Returns the next item from the CircularQueue.
         *
         * @return Object
         */
        public synchronized Object get() {
            if (next >= items.length) {
                next = 0;
            }
            return items[next++];
        }
    }

}
