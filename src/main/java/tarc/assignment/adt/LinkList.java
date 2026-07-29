package tarc.assignment.adt;

public class LinkList<T> {
    private Node firstNode;
    private int size;

    private class Node {
        private T data; // entry in list
        private Node next; // link to next node
        private Node(T data) {
            this.data = data;
            next = null;
        }
        private Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
