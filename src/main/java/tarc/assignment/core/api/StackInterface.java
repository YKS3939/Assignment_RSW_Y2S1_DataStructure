package tarc.assignment.core.api;

/**
 * Ma Chun Yen
 * @param <T>
 */
public interface StackInterface<T>{
    void push(T item);
    T pop();
    T peek();
    boolean isEmpty();
    void clear();
}
