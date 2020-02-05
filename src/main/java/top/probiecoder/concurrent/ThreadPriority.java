package top.probiecoder.concurrent;

public class ThreadPriority {
    public static void main(String[] args) {
        /*Thread t1 = new Thread(() -> {
            while (true) {
                System.out.println("t1");
            }
        });
        t1.setPriority(3);

        Thread t2 = new Thread(() -> {
            while (true) {
                System.out.println("t2");
            }
        });
        t2.setPriority(10);

        t1.start();
        t2.start();*/

        ThreadGroup threadGroup = new ThreadGroup("test-group");
        threadGroup.setMaxPriority(7);

        Thread thread = new Thread(threadGroup, "test-thread");
        thread.setPriority(10);   // 线程优先级大于所在组最大优先级时不生效,设置为所在组最大优先级
        System.out.println(thread.getId());
        System.out.println(thread.getPriority());
    }
}
