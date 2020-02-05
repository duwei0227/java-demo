package top.probiecoder.readwritesplit;

public class ReadLock implements Lock {
    private final ReadWriteLockImpl readWriteLock;

    public ReadLock(ReadWriteLockImpl readWriteLock) {
        this.readWriteLock = readWriteLock;
    }

    @Override
    public void lock() throws InterruptedException {
        // 使用MUTEX作为锁
        synchronized (readWriteLock.getMUTEX()) {
            // 若此时有线程在进行写操作,或者有写线程在等待并且偏向锁的标志位true时,
            // 就会无法获得锁,只能被挂起
            while (readWriteLock.getWritingWriters() > 0 || (readWriteLock.getPreferWriter() && readWriteLock.getWaitingWriters() > 0)) {
                readWriteLock.getMUTEX().wait();
            }
            // 成功获得读锁,并且使readingReaders的数量增加
            readWriteLock.incrementReadingReaders();
        }
    }

    @Override
    public void unlock() {

    }
}
