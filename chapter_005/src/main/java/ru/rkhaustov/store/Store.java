package ru.rkhaustov.store;


/**
 * interface Store.
 * @param <T> T
 */
public interface Store<T extends Base>  {
    /**
     * @param value value.
     */
    void add(T value);

    /**
     * @param id id
     */
    void delete(String id);

    /**
     * @param value T
     * @param id id
     */
    void update(T value, String id);

}
