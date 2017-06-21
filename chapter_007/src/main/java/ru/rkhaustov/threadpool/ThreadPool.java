package ru.rkhaustov.threadpool;

/**
 * Created by rvkha_000 on 20.06.2017.
 */
public class ThreadPool {

    /**
     * work.
     */
    private Work work;
    /**
     * Current pool.
     */
    private int pools = 0;

    /**
     * Constructor Initializing the pool by the number of cores in the system.
     */
    public ThreadPool() {
        for (int pool = 0; pool < Runtime.getRuntime().availableProcessors(); pool++) {
            new Thread() {
                @Override
                public void run() {
                    addThread();
                }
            }.start();
        }
    }

    /**
     * addThread.
     */
    public void addThread() {
        Thread.currentThread().setName(String.format("Thread %s", pools++));
        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            this.get();
        }
    }

    /**
     * get queue.
     */
    public synchronized void get() {
        while (work == null) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.work.doWork();
        this.work = null;
        this.notifyAll();
    }

    /**
     * add queue.
     * @param work work
     */
    public synchronized void add(Work work) {
        while (this.work != null) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.work = work;
        this.notifyAll();
    }
}
