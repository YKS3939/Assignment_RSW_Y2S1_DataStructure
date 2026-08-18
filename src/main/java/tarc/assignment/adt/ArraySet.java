package tarc.assignment.adt;

import tarc.assignment.core.api.SetInterface;

/**
 *  Yap Kim Soon & Ng Zhun Onn
 */
public class ArraySet<T extends Comparable<T>> implements SetInterface<T> {
    private final ArrayList<T> items;
    private static final int DEFAULT_CAPACITY = 25;

    public ArraySet() {
        this.items = new ArrayList<>(DEFAULT_CAPACITY);
    }

    @Override
    public boolean add(T data) {
        if (!contains(data)) {
            items.add(data);
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(T element) {
        int index = items.getPosition(element);
        if (index == -1) {
            return false;
        }
        items.remove(index);
        return true;
    }

    @Override
    public boolean contains(T element) {
        return items.getPosition(element) != -1;
    }

    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public int getSize() {
        return items.getSize();
    }

    @Override
    public void clear() {
        items.clear();
    }

    @Override
    public ArrayList<T> all() {
        ArrayList<T> all = new ArrayList<>(items.getSize());
        for (int i = 0; i < items.getSize(); i++) {
            all.add(items.get(i));
        }
        return all;
    }

    @Override
    public T get(T data) {
        if (data == null) return null;

        for (int i = 0; i < items.getSize(); i++) {
            T current = items.get(i);
            if (current.compareTo(data) == 0) {
                return current;
            }
        }
        return null;
    }

    @Override
    public T get(int index) {
        return items.get(index);
    }

    @Override
    public String toString() {
        return "Set{" +
                "items=" + items +
                '}';
    }
}