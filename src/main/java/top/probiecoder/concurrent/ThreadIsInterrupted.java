package top.probiecoder.concurrent;

import java.util.concurrent.TimeUnit;

public class ThreadIsInterrupted {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    System.out.println("I am interrupted");
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
        TimeUnit.MILLISECONDS.sleep(2);
        System.out.println(String.format("Thread is interrupted ? %s \n", thread.isInterrupted()));
        thread.interrupt();
        System.out.println(String.format("Thread is interrupted ? %s \n", thread.isInterrupted()));
    }
}
