package tarc.assignment.adt;

/**
 *  Ma Chun Yen
 */
public class Stack<T>{
    private ArrayList<T> stack;
    private static final int DEFAULT_CAPACITY = 25;

    public Stack(){
        stack = new ArrayList<>(DEFAULT_CAPACITY);
    }

    public void push(T item){
        stack.add(item);
    }

    public T pop(){
        if (isEmpty()) {
            return null;
        }
        return stack.remove(stack.getSize()-1);
    }

    public T peek(){
        if (isEmpty()) {
            return null;
        }
        return stack.get(stack.getSize()-1);
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public boolean isFull(){
        return false;//Unlimited knp nk true
    }

    public void clear(){
        stack.clear();
    }
//
//    public void push(T item)
//    public T pop()
//    public boolean isEmpty()
//    public boolean isFull()
//    public T peek()
//    public void clear()

}
