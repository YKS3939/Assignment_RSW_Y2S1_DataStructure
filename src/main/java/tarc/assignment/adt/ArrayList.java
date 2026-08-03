package tarc.assignment.adt;

/**
 * Everyone share
 */
public class ArrayList<T>{
    private T[] list;
    private int size;
    private static final int DEFAULT_CAPACITY = 25;

    public ArrayList(int initialCapacity){
        if (initialCapacity < 1) {
            initialCapacity = DEFAULT_CAPACITY;
        }
        list = (T[]) new Object[initialCapacity];
        size = 0;
    }
    //I also don't know why can run, if can don't touch
    public void add(T newEntry){
        if (isFull()) {
            extend();
        }
        list[size] = newEntry;
        size++;
    }
    public boolean add(int newPosition, T newEntry){
        if (newPosition < 0 || newPosition > size) {
            return false;
        }

        if (isFull()) {
            extend();
        }
        for(int i=size-1;i>=newPosition;i--){
            list[i+1]=list[i];
        }
        list[newPosition]=newEntry;

        size++;
        return true;
    }

    public T remove(int givenPosition) {
        if (givenPosition < 0 || givenPosition >= size) {
            return null;
        }

        T result = list[givenPosition];

        for (int i = givenPosition; i < size - 1; i++) {
            list[i] = list[i + 1];
        }

        list[size - 1] = null;
        size--;
        return result;
    }

    public boolean replace(int givenPosition, T newEntry) {
        if (givenPosition < 0 || givenPosition >= size) {
            return false;
        }
        list[givenPosition] = newEntry;

        return true;
    }


    public void clear(){
        for(int i=0;i<size;i++){
                list[i]=null;
        }
        size=0;
    }
    public T get(int givenPosition) {
        if (givenPosition < 0 || givenPosition >= size) {
            return null;
        }
        return list[givenPosition];
    }

    public boolean isFull(){
        return size==list.length;
    }

    public boolean isEmpty(){
        return size==0;
    }

    //this method are use AI - Yap Kim Soon
    public boolean contains(T anEntry) {
        for (int i = 0; i < size; i++) {
            if (anEntry == null) {
                if (list[i] == null) return true;
            } else if (anEntry.equals(list[i])) {
                return true;
            }
        }
        return false;
    }


    private void extend(){
        int length = list.length * 2;
        T[] original=list;
        list=(T[]) new Object[length];
        System.arraycopy(original, 0, list, 0, size);
    }

    public int getSize(){
        return size;
    }

    //public void add(T newEntry)
    //public boolean add(int newPosition, T newEntry)
    //public T remove(int givenPosition)
    //public boolean replace(int givenPosition, T newEntry)
    //public T getEntry(int givenPosition)
    //public boolean contains(T anEntry)
}
