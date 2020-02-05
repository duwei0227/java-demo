package top.probiecoder.concurrent;

/**
 * 用于存放提交的<code>Runnable</code>,是一个BlockedQueue
 * 并且有limit限制
 */
public interface RunnableQueue {
    // 添加到队列
    void offer(Runnable runnable);

    // 获取队列中的Runnable
    Runnable take() throws InterruptedException;

    // 获取任务队列中的任务数量
    int size();
}
