package company.lnkin.design;

import java.util.HashMap;
import java.util.Map;

/**
 * http://tutorials.jenkov.com/java-concurrency/read-write-locks.html#simple
 */
public class ReadWriteLock {
    private Map<Thread, Integer> readingThreads = new HashMap<>();

    private int writeAccesses = 0;
    private int writeRequests = 0;
    private Thread writingThread = null;

    public synchronized void lockRead() throws InterruptedException {
        Thread callingThread = Thread.currentThread();
        while (!canGrantReadAccess(callingThread)) {
            wait();
        }
        this.readingThreads.put(callingThread, getReadAccessCount(callingThread) + 1);
    }

    public synchronized void unlockRead() {
        Thread callingThread = Thread.currentThread();
        if (!isReader(callingThread)) {
            throw new IllegalMonitorStateException("Calling Thread does not hold a read lock on this ReadWriteLock");
        }
        int accessCount = getReadAccessCount(callingThread);
        if (accessCount == 1) {
            this.readingThreads.remove(callingThread);
        } else {
            this.readingThreads.put(callingThread, accessCount - 1);
        }
        notifyAll();
    }

    public synchronized void lockWrite() throws InterruptedException {
        this.writeRequests++;
        Thread callingThread = Thread.currentThread();
        while (!canGrantWriteAccess(callingThread)) {
            wait();
        }
        this.writeRequests--;
        this.writeAccesses++;
        this.writingThread = callingThread;
    }

    public synchronized void unlockWrite() throws InterruptedException {
        if (!isWriter(Thread.currentThread())) {
            throw new IllegalMonitorStateException("Calling Thread does not hold the write lock on this ReadWriteLock");
        }
        this.writeAccesses--;
        if (this.writeAccesses == 0) {
            this.writingThread = null;
        }
        notifyAll();
    }

    private boolean canGrantReadAccess(Thread callingThread) {
        if (isWriter(callingThread)) {
            return true;
        }
        if (hasWriter()) {
            return false;
        }
        if (isReader(callingThread)) {
            return true;
        }
        if (hasWriteRequests()) {
            return false;
        }
        return true;
    }

    private boolean canGrantWriteAccess(Thread callingThread) {
        if (isOnlyReader(callingThread)) {
            return true;
        }
        if (hasReaders()) {
            return false;
        }
        if (this.writingThread == null) {
            return true;
        }
        if (!isWriter(callingThread)) {
            return false;
        }
        return true;
    }

    private int getReadAccessCount(Thread callingThread) {
        return this.readingThreads.getOrDefault(callingThread, 0);
    }

    private boolean hasReaders() {
        return !this.readingThreads.isEmpty();
    }

    private boolean isReader(Thread callingThread) {
        return this.readingThreads.get(callingThread) != null;
    }

    private boolean isOnlyReader(Thread callingThread) {
        return this.readingThreads.size() == 1 && this.readingThreads.get(callingThread) != null;
    }

    private boolean hasWriter() {
        return this.writingThread != null;
    }

    private boolean isWriter(Thread callingThread) {
        return this.writingThread == callingThread;
    }

    private boolean hasWriteRequests() {
        return this.writeRequests > 0;
    }
}
