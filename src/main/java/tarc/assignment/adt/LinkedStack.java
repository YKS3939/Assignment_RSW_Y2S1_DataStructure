package tarc.assignment.adt;

/**
 *  Ma Chun Yen
 */
public class LinkedStack <T>{
    private Node top;
    private int size;

    public LinkedStack(){
        this.top=null;
        this.size=0;
    }

    public void push(T item){
        Node newNode=new Node(item);
        newNode.next=top;
        top=newNode;
        size++;
    }

    public T pop(){
        if (isEmpty()) {
            return null;
        }
        T data= top.data;
        top=top.next;
        size--;
        return data;
    }

    public T peek(){
        if (isEmpty()) {
            return null;
        }
        return top.data;
    }

    public boolean isEmpty(){
        return size==0;
    }


    public void clear(){
        this.top=null;
        size=0;
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
