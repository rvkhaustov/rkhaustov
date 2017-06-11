package ru.rkhaustov.orderbook;

/**
 * Created by rvkha_000 on 09.06.2017.
 */
public class Order {
    /**
     * Price.
     */
    private float price;
    /**
     * Volume.
     */
    private int volume;

    /**
     * Constructor.
     * @param price  price
     * @param volume volume
     */
    public Order(float price, int volume) {
        this.price = price;
        this.volume = volume;
    }

    /**
     * @return price.
     */
    public float getPrice() {
        return price;
    }


    /**
     * @return volume.
     */
    public int getVolume() {
        return volume;
    }
}
