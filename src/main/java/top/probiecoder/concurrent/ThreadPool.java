package top.probiecoder.concurrent;

public interface ThreadPool {
    // 提交任务到线程池
    void execute(Runnable runnable);

    // 关闭线程池
    void shutdown();

    // 获取线程池的初始大小 init
    int getInitSize();

    // 获取线程池最大的线程数 max
    int getMaxSize();

    // 获取线程池的核心线程数量 core
    int getCoreSize();

    // 获取线程池中用于缓存任务队列的大小
    int getQueueSize();

    // 活跃线程数量
    int getActiveSize();

    // 查看线程池是否已经被shutdown
    boolean isShutdown();
}
