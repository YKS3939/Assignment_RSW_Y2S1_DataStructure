package tarc.assignment.core.api;

public interface QueueInterface<T>{
    public int getSize();
    boolean isEmpty();
    T peek();
    void enqueue(T item);
    T dequeue();
    void clear();
}
