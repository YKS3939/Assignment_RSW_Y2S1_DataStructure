package tarc.assignment.adt;

import tarc.assignment.core.api.StackInterface;

/**
 * Ma Chun Yen
 */
public class LinkedStack<T> implements StackInterface<T> {
    private Node top;
    private int size;

    public LinkedStack() {
        this.top = null;
        this.size = 0;
    }

    @Override
    public void push(T item) {
        Node newNode = new Node(item);
        newNode.next = top;
        top = newNode;
        size++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return top.data;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        this.top = null;
        size = 0;
    }

    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
}
