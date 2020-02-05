package top.probiecoder.readwritesplit;

public interface Lock {
    void lock() throws InterruptedException;

    void unlock();
}
