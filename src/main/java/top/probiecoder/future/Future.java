package top.probiecoder.future;

public interface Future<T> {
    T get() throws InterruptedException;

    boolean done();
}
