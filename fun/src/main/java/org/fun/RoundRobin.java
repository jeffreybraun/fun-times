package org.fun;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class RoundRobin {
    static ConcurrentMap<Object, AtomicInteger> counts = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue("a", "b", "c");
        IntStream.range(0, 1000)
                .parallel()
                .forEach(i -> countItem(circularQueue));
        counts.forEach(
                (k, v) -> {
                    System.out.println(k + " " + v);
                }
        );
    }

    public static void countItem(CircularQueue circularQueue) {
        var item = circularQueue.get();
        counts.putIfAbsent(item, new AtomicInteger(0));
        counts.get(item).incrementAndGet();
    }

    static class CircularQueue {

        private final Object[] items;
        private int next = 0;

        public <T> CircularQueue(T... items) {
            this.items = items;
        }

        public synchronized Object get() {
            if (next >= items.length) {
                next = 0;
            }
            return items[next++];
        }

    }

}
