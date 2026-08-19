package tarc.assignment.adt;

import tarc.assignment.core.api.TreeInterface;

/**
 * Goh Wen Ting
 */
public class BinaryTree<T extends Comparable<T>> implements TreeInterface<T> {
    private Node<T> root;

    public BinaryTree() {
        this.root = null;
    }

    @Override
    public void insert(T newData) {
        if (newData == null) return;
        root = insertRecursive(root, newData);
    }

    @Override
    public T search(T key) {
        if (key == null || isEmpty()) return null;
        return searchRecursive(root, key);
    }

    @Override
    public void clear() {
        this.root = null;
    }

    @Override
    public boolean isEmpty() {
        return this.root == null;
    }

    private Node<T> insertRecursive(Node<T> current, T newData) {
        if (current == null) return new Node<>(newData);
        int result = newData.compareTo(current.data);

        if (result < 0) {
            current.left = insertRecursive(current.left, newData);
        } else if (result > 0) {
            current.right = insertRecursive(current.right, newData);
        } else {
            current.data = newData;
        }
        return current;
    }

    private T searchRecursive(Node<T> current, T key) {
        if (current == null) return null;
        int result = key.compareTo(current.data);
        if (result == 0) {
            return current.data;
        } else if (result > 0) {
            return searchRecursive(current.right, key);
        } else {
            return searchRecursive(current.left, key);
        }
    }

    private static class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;

        Node(T data) {
            this.data = data;
        }
    }
}
