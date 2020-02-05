package top.probiecoder.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 基于执行时间的同步类
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        Thread thread1 = new TranslateThread("1st content", countDownLatch);
        Thread thread2 = new TranslateThread("2nd content", countDownLatch);
        Thread thread3 = new TranslateThread("3rd content", countDownLatch);

        thread1.start();
        thread2.start();
        thread3.start();

        countDownLatch.await(10, TimeUnit.SECONDS);
        System.out.println("所有线程执行完成");
    }
}

class TranslateThread extends Thread {
    private String content;
    private final CountDownLatch count;

    public TranslateThread(String content, CountDownLatch count) {
        this.content = content;
        this.count = count;
    }

    @Override
    public void run() {
        // 在某种情况下,执行翻译解析时,抛出异常
        if (Math.random() > 0.5) {
            throw new RuntimeException("原文存在非法字符");
        }

        System.out.println(content + " 的翻译已经完成,译文是....");
        System.out.println(count.getCount());
        count.countDown();
    }
}