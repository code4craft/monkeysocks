package com.dianping.monkeysocks.socket;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * A stream buffer in producer&consumer pattern.<br>
 *
 * @author yihua.huang@dianping.com <br>
 * @date: 13-7-9 <br>
 * Time: 下午8:21 <br>
 */
public class StreamBuffer {

    private byte[] buffer;

    private int capacity;

    private int readPointer;

    private int writePointer;

    private ReentrantLock lock;

    private Condition full;

    private Condition empty;

    public static StreamBuffer allocate(int capacity) {
        if (capacity <= 0)
            throw new IllegalArgumentException("capacity must greater than 0");
        return new StreamBuffer(capacity);
    }

    StreamBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new byte[capacity];
        this.lock = new ReentrantLock();
        this.full = lock.newCondition();
        this.empty = lock.newCondition();
    }

    public byte read() {
        try {
            lock.lock();
            while (readPointer >= writePointer) {
                empty.await();
            }
            byte b = buffer[readPointer % capacity];
            readPointer++;
            full.signal();
            //end
            return b;
        } catch (InterruptedException e) {
        } finally {
            lock.unlock();
        }
        return 0;
    }

    public void write(byte b) {
        try {
            lock.lock();
            //end
            while (writePointer - readPointer >= capacity) {
                full.await();
            }
            buffer[writePointer % capacity] = b;
            writePointer++;
            empty.signal();
        } catch (InterruptedException e) {
        } finally {
            lock.unlock();
        }
    }

}
