package concurrentcy;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Synchronized {

    @Test
    public void testIII() throws InterruptedException {
        Synchronized x = new Synchronized();
        Synchronized y = new Synchronized();

        Thread a = new Thread(x::syncA);
        a.start();

        Thread b = new Thread(x::syncB);
        b.start();

//        Thread c = new Thread(LockI::syncC);
//        c.start();

        Thread.sleep(10000);
    }

    private synchronized void syncA() {
        try {
            System.out.println(convertDate() + "-當前thread:" + Thread.currentThread().getName() + "-執行syncA");
            Thread.sleep(2000);
        } catch (Exception e) {
        }

        System.out.println(convertDate() + " syncA 執行完畢");
    }

    private synchronized void syncB() {
        try {
            System.out.println(convertDate() + "-當前thread:" + Thread.currentThread().getName() + "-執行syncB");
            Thread.sleep(2000);
        } catch (Exception e) {
        }

        System.out.println(convertDate() + " syncB 執行完畢");
    }

    private static synchronized void syncC() {
        try {
            System.out.println(convertDate() + "-當前thread:" + Thread.currentThread().getName() + "-執行syncC");
            Thread.sleep(2000);
        } catch (Exception e) {
        }

        System.out.println(convertDate() + " syncC 執行完畢");
    }

    private static synchronized void syncD() {
        try {
            System.out.println(convertDate() + "-當前thread:" + Thread.currentThread().getName() + "-執行syncD");
            Thread.sleep(2000);
        } catch (Exception e) {
        }

        System.out.println(convertDate() + " syncD 執行完畢");
    }

    private static String convertDate() {
        SimpleDateFormat f = new SimpleDateFormat("HH:mm:ss");
        return f.format(new Date());
    }
}
