package ru.rkhaustov.lock;

/**
 * Created by rvkha_000 on 21.06.2017.
 */
public class Lock {
    /**
     * lockThread.
     */
    private Object lockThread = new Object();
    /**
     * lockDoWork.
     */
    private Boolean lockDoWork = true;


    /**
     * doWork.
     * @throws InterruptedException InterruptedException
     */
    public void doWork() throws InterruptedException {

        synchronized (this.lockThread) {
            while (true) {
                while (lockDoWork) {
                    System.out.println("Thread wait");
                    this.lockThread.wait();
                }

                System.out.println("Thread Todo");

                this.lockThread.wait();
                if (Thread.currentThread().isInterrupted()) {
                    return;
                }
                this.lockThread.notify();
            }
        }
    }

    /**
     * @param flag lockDoWork
     */
    public void changeLock(boolean flag) {
        synchronized (this.lockThread) {
            this.lockDoWork = flag;
            this.lockThread.notify();
        }
    }
}
