package top.probiecoder.concurrent;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 基于信号
 */
public class CustomCheckWindow {
    public static void main(String[] args) {
        // 设定3个信号量,即3个服务窗口
        Semaphore semaphore = new Semaphore(3);

        // 队列 5
        for (int i = 0; i < 5; i++) {
            new SecurityCheckThread(i, semaphore).start();
        }
    }

    private static class SecurityCheckThread extends Thread {
        private int seq;
        private Semaphore semaphore;

        public SecurityCheckThread(int seq, Semaphore semaphore) {
            this.seq = seq;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("No." + seq + "乘客,正在查验中");

                // 假设号码是整除2的人是身份可疑的人,需要花更长时间安检
                if (seq % 3 == 0) {
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println("No." + seq + "乘客,身份可疑,不能出国! ");
                }else {
                    TimeUnit.SECONDS.sleep(2);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
                System.out.println("No." + seq + "乘客已完成服务.");
            }
        }
    }
}
