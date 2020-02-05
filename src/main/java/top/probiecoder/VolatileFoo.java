package top.probiecoder;

import java.util.concurrent.TimeUnit;

public class VolatileFoo {
    final static int MAX = 5;  // 最大值
    static volatile int init_value = 0;    // 初始值

    public static void main(String[] args) {
        // Reader线程,当发现local_value和init_value不同时,则输出init_value被修改的信息
        new Thread(()->{
            int localValue = init_value;
            while (localValue < MAX) {
                if (init_value != localValue) {
                    System.out.printf("The init_value is updated to [%d]\n", init_value);
                    localValue = init_value;
                }
            }
        }, "Reader").start();

        // Updater线程,对init_value修改,当local_value>=5时退出
        new Thread(()->{
            int localValue = init_value;
            while (localValue < MAX) {
                // 修改
                System.out.printf("The init_vavlue will be changed to [%d]\n", ++localValue);
                init_value = localValue;
                try {
                    // 短暂休眠使Reader线程能够来得及输出变化内容
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Updater").start();
    }
}
