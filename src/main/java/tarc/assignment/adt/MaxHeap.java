package tarc.assignment.adt;

//left: 2*i+1
//right: 2*i+2

public class MaxHeap<T extends Comparable<T>>{
    private T[] heap;
    private int size;
    private static final int DEFAULT_CAPACITY = 25;

    @SuppressWarnings("unchecked")
    public MaxHeap(int initialCapacity){
        heap = (T[]) new Comparable[initialCapacity];
        size=0;
    }

    public MaxHeap() {
        this(DEFAULT_CAPACITY);
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public T peekMax(){
        if (isEmpty()) {
            return null;
        }
        return heap[0];
    }

    public void clear(){
        for (int i=0;i<size;i++){
            heap[i]=null;
        }
        size=0;
    }

    public boolean isFull(){
        return size==heap.length;
    }

    public T extractMax(){
        if (isEmpty()) {
            return null;
        }
        T root=heap[0];
        heap[0] = heap[size - 1];
        size--;
        if (!isEmpty()){
            shiftDown(0);
        }
        return root;
    }

    public void insert(T item){
        if (isFull()) {
            extend();
        }
        heap[size]=item;
        shiftUp(size);
        size++;
    }

    @SuppressWarnings("unchecked")
    private void extend() {
        int length = heap.length * 2;
        T[] original = heap;
        heap = (T[]) new Comparable[length];
        System.arraycopy(original, 0, heap, 0, size);
    }

    private void swap(int i, int j) {
        T data = heap[i];
        heap[i] = heap[j];
        heap[j] = data;
    }

    //this method are use AI - Yap Kim Soon
    private void shiftDown(int index){
        int left = 2 * index + 1;
        while (left < size) {
            int maxChild = left;
            int right = left + 1;

            if (right < size && heap[right].compareTo(heap[left]) > 0) {
                maxChild = right;
            }

            if (heap[index].compareTo(heap[maxChild]) >= 0) {
                break;
            }

            swap(index, maxChild);
            index = maxChild;
            left = 2 * index + 1;
        }
    }
    private void shiftUp(int index){
        //parent: (i-1) / 2
         int parent = (index - 1) / 2;
            while (index > 0 && heap[index].compareTo(heap[parent]) > 0) {
                swap(index, parent);
                index = parent;
                parent = (index - 1) / 2;
            }
    }
    //    public void insert(T item)
    //    public T extractMax()
    //    public T peekMax()
    //    private void shiftUp(int index)
    //    private void shiftDown(int index)
    //    public int size()
    //    public boolean isEmpty()
    //    public void clear()
}
