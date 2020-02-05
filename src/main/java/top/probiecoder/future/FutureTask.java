package top.probiecoder.future;

public class FutureTask<T> implements Future<T> {
    @Override
    public T get() throws InterruptedException {
        return null;
    }

    @Override
    public boolean done() {
        return false;
    }
}
