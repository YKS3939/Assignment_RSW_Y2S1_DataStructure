package tarc.assignment.adt;

public class Set<T extends Comparable<T>>{
    private final ArrayList<T> items;
    private static final int DEFAULT_CAPACITY = 25;

    public Set() {
        this.items = new ArrayList<>(DEFAULT_CAPACITY);
    }


    public boolean add(T data) {
        if (!contains(data)) {
            items.add(data);
            return true;
        }
        return false;
    }

    public boolean remove(T element) {
        int index = items.getPosition(element);
        if (index == -1) {
            return false;
        }
        items.remove(index);
        return true;
    }

    public boolean contains(T element) {
        return items.getPosition(element) != -1;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public int getSize() {
        return items.getSize();
    }

    public void clear() {
        items.clear();
    }

    public ArrayList<T> all() {
        ArrayList<T> all = new ArrayList<>(items.getSize());
        for (int i = 0; i < items.getSize(); i++) {
            all.add(items.get(i));
        }
        return all;
    }

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