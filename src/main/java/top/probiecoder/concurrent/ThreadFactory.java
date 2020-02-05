package top.probiecoder.concurrent;

@FunctionalInterface
public interface ThreadFactory {
    Thread createThread(Runnable runnable);
}
