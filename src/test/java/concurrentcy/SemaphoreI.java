package concurrentcy;

import org.junit.Test;

import java.util.concurrent.Semaphore;

public class SemaphoreI {

    private Semaphore semaphore = new Semaphore(1);

    @Test
    public void test() throws InterruptedException {

        Thread a = new Thread(() -> {
            try {
                semaphore.acquire();
                System.out.println("Get semaphore start");
                semaphore.release();
            } catch (Exception e) {
                System.out.println("Get semaphore error");
            }
        });
        a.start();

        Thread b = new Thread(() -> {
            try {
                semaphore.acquire();
                System.out.println("Get semaphore start");
            } catch (Exception e) {
                System.out.println("Get semaphore error");
            }
        });
        b.start();

        Thread.sleep(3000);
    }
}
