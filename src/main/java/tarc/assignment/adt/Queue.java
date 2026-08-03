package tarc.assignment.adt;

/**
 *  Ng Zhun Onn
 */
public class Queue <T>{
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public Queue(){
        this.head=null;
        this.tail=null;
        this.size=0;
    }


    private static class Node<T>{
        T data;
        Node<T> next;

        Node(T data){
            this.data=data;
            this.next=null;}
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public T peek(){
        return isEmpty()?null:head.data;
//        if(isEmpty()) return null;
//        return head.data;
    }

    public void enqueue(T item){
        Node<T> newNode=new Node<>(item);
        if (isEmpty()){
            head=newNode;
            tail=newNode;
        }else {
            tail.next=newNode;
            tail=newNode;
        }
        size++;
    }
    public T dequeue(){
        if (isEmpty()){
            return null;
        }
        T data = head.data;
        head = head.next;
        size--;
        if (head==null){
            tail=null;
        }
        return data;
    }

    public void clear(){
        head=null;
        tail=null;
        size=0;
    }

//    public void enqueue(T item)
//    public T dequeue()
//    public T peek()
//    public int size()
//    public boolean isEmpty()
//    public void clear()
}
