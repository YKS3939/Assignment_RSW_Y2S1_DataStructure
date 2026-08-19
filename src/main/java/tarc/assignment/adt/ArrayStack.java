package tarc.assignment.adt;

import tarc.assignment.core.api.StackInterface;

/**
 * Ma Chun Yen
 */
@Deprecated
public class ArrayStack<T> implements StackInterface<T> {
    private ArrayList<T> stack;
    private static final int DEFAULT_CAPACITY = 25;

    public ArrayStack() {
        stack = new ArrayList<>(DEFAULT_CAPACITY);
    }

    @Override
    public void push(T item) {
        stack.add(item);
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        return stack.remove(stack.getSize() - 1);
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return stack.get(stack.getSize() - 1);
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public boolean isFull() {
        return false;// Unlimited knp nk true
    }

    @Override
    public void clear() {
        stack.clear();
    }
}
