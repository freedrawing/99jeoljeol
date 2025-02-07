package thread_test;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {

    private int count = 0;
//    private AtomicInteger count = new AtomicInteger();

    public void increment() {
        count++;
//        count.getAndAdd(1);
    }

    @Test
    void atomicTest() throws InterruptedException {
        AtomicTest atomicTest = new AtomicTest();

        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    atomicTest.increment();
                }
            });
            threads[i].start();
        };

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("count=" + atomicTest.count);
    }
}
