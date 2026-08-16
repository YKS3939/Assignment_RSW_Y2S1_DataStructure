package tarc.assignment.core.api;

public interface TreeInterface<T> {
    void insert(T newData);
    T search(T key);
    void clear();
    boolean isEmpty();

}
