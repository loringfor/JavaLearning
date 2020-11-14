package com.loring.threads.chapter05;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class TwinsLock implements Lock {
    private final SyncTest syncTest = new SyncTest(2);

    private static final class SyncTest extends AbstractQueuedSynchronizer{
        private static final long serialVersionUID = -7889272986162341211L;
        public SyncTest(){}
        public SyncTest(int count){
            if(count<0){
                throw new IllegalArgumentException("count must large than zero.");
            }
            setState(count);
        }

        @Override
        protected int tryAcquireShared(int reduceCount) {
            for(;;){
                int current = getState();
                int newCount = current - reduceCount;
                if(newCount<0 || compareAndSetState(current,newCount)){
                    return newCount;
                }
            }
        }

        @Override
        protected boolean tryReleaseShared(int returnCount) {
            for(;;){
                int current = getState();
                int newCount = current + returnCount;
                if(compareAndSetState(current,newCount)){
                    return true;
                }
            }
        }

        final ConditionObject newCondition() {
            return new ConditionObject();
        }
    }

    @Override
    public void lock() {
        syncTest.acquireShared(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        syncTest.acquireSharedInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return syncTest.tryAcquireShared(1)>=0;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return syncTest.tryAcquireSharedNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        syncTest.releaseShared(1);
    }

    @Override
    public Condition newCondition() {
        return syncTest.newCondition();
    }
}
