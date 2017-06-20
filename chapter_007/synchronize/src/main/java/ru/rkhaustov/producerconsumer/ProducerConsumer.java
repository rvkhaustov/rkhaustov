package ru.rkhaustov.producerconsumer;


/**
 * Created by rvkha_000 on 20.06.2017.
 * @param <T> object.
 */
public class ProducerConsumer<T> {

    /**
     * object.
     */
    private Object object;

    /**
     * @return object.
     */
    public synchronized T getObject() {
        return (T) object;
    }

    /**
     * @param value value
     */
    public synchronized void add(T value) {

        while (object != null) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.object = value;
        this.notifyAll();
    }

    /**
     * @return object
     */
    public  synchronized T get()  {
        while (object == null) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Object objectValue = this.object;
        this.object = null;

        this.notifyAll();
        return (T) objectValue;

    }
}
