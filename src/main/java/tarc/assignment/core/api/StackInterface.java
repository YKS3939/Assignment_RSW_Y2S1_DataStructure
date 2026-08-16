package tarc.assignment.core.api;

public interface StackInterface<T>{
    void push(T item);
    T pop();
    T peek();
    boolean isEmpty();
    void clear();
}
