package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * http://static.kancloud.cn/oliver_lin/java-thread/1889681
 */
public class TestReadWriteLock {
    public static void main(String[] args) {
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        Lock writeLock = readWriteLock.writeLock();
        Lock readLock = readWriteLock.readLock();

        readLock.lock();
        System.out.println(Thread.currentThread().getName() + "got the readlock");
        writeLock.lock();
        System.out.println(Thread.currentThread().getName() + "got the writeLock");
        /**
         * 死锁，该读写锁不支持升级，获取读锁后尝试获取写锁，线程会阻塞在readlock.unlock();
         * 然后write.lock()也在执行，所以死锁出现；
         */
    }
}
