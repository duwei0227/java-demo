package top.probiecoder.concurrent;

/**
 * 主要用于线程池内部,不断从queue中取出某个Runnable
 */
public class InternalTask implements Runnable {
    private final RunnableQueue runnableQueue;
    private volatile boolean running = false;

    public InternalTask(RunnableQueue runnableQueue) {
        this.runnableQueue = runnableQueue;
    }

    @Override
    public void run() {
        // 如果当前任务为running并且没有被中断,则其不断地从queue中获取runnable,然后执行run方法
        while (running && !Thread.currentThread().isInterrupted()) {
            Runnable task = null;
            try {
                task = runnableQueue.take();
                task.run();
            } catch (InterruptedException e) {
                this.running = false;
                break;
            }
        }
    }

    public void stop() {
        this.running = false;
    }

}
