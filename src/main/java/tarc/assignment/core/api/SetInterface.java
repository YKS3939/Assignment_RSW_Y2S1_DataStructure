package tarc.assignment.core.api;

import tarc.assignment.adt.ArrayList;

public interface SetInterface<T> {
    boolean add(T data);
    boolean remove(T element);
    boolean contains(T element);
    boolean isEmpty();
    int getSize();
    void clear();
    ArrayList<T> all();
    T get(T data);
    T get(int index);
}
