package lockTest;

import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author duankd
 * @ClassName ReentrantLockTest
 * @date 2021-03-03 16:44:05
 */
public class ReentrantLockTest {
    @Test
    void lockTest() {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        System.out.println("加锁成功");
        //
        lock.unlock();
        System.out.println("解锁成功");
    }


    @Test
    void otherLockTest() {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
        writeLock.lock();
        System.out.println("加锁成功");
        //
        writeLock.unlock();
        System.out.println("解锁成功");
        ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
        readLock.lock();
        System.out.println("加锁成功");
        //
        readLock.unlock();
        System.out.println("解锁成功");
    }

}
