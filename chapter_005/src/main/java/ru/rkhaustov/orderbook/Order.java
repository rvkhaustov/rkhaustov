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

    /**
     * @param o object
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Order order = (Order) o;

        if (Float.compare(order.price, price) != 0) {
            return false;
        }
        return volume == order.volume;
    }

    /**
     * @return result
     */
    @Override
    public int hashCode() {
        int result = (price != +0.0f ? Float.floatToIntBits(price) : 0);
        result = 31 * result + volume;
        return result;
    }
}
