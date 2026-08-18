package tarc.assignment.core.api;

/**
 * Goh Wen Ting
 * @param <T>
 */
public interface TreeInterface<T> {
    void insert(T newData);
    T search(T key);
    void clear();
    boolean isEmpty();

}
