package tarc.assignment.core.api;

public interface HeapInterface<T> {
    int getSize();
    boolean isEmpty();
    T peek();
    void clear();
    boolean isFull();
    T extract();
    void insert(T item);
}
