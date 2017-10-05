package main.java.com.kha.thread;

/**
 * Created by Mohammad.Ansari1 on 05-10-2017.
 */
public class CustomReentrantLock {
    static final long MAX_DEFAULT_WAIT_TIME = 1000;
    int reentrantLockCounter=0;
    Thread lockOwnerThread;
    boolean isLocked;

    private boolean lock(long waitTime) throws InterruptedException {
        Thread currentThread = Thread.currentThread();
        if(reentrantLockCounter==0){
            reentrantLockCounter++;
            lockOwnerThread = currentThread;
            isLocked = true;
        }else if(reentrantLockCounter >0 && lockOwnerThread == currentThread ){
            reentrantLockCounter++;
        }else {
            wait(waitTime);
            if(!isLocked){
                reentrantLockCounter++;
                lockOwnerThread = currentThread;
                isLocked = true;
            }
        }
        return (isLocked && (lockOwnerThread == currentThread));
    }

    public synchronized boolean lock() throws InterruptedException {
        return lock(0);
    }



    public synchronized boolean tryLock() throws InterruptedException {
        if(isLocked){
            return false;
        }else {
            return lock(MAX_DEFAULT_WAIT_TIME);
        }
    }

    public synchronized boolean tryLock(long waitTime) throws InterruptedException {
        return lock(waitTime);
    }

    public synchronized boolean unLock() throws Exception {
        Thread currentThread = Thread.currentThread();
        if(reentrantLockCounter ==1 && lockOwnerThread == currentThread ){
            reentrantLockCounter--;
            isLocked = false;
            notify();
            return true;
        }else if(reentrantLockCounter >1 && lockOwnerThread == currentThread ){
            reentrantLockCounter--;
            return true;
        }else {
            return false;
        }
    }


}
