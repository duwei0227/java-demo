package top.probiecoder.concurrent;

import java.util.concurrent.TimeUnit;

public class TimeUnitDemo {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        TimeUnit.SECONDS.sleep(1);
        TimeUnit.MINUTES.sleep(1);
        long end = System.currentTimeMillis();
        System.out.println(String.format("Total sleep time %d", (end - start)));

    }
}
