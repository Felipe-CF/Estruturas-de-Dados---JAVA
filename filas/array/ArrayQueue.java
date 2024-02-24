package array;

public class ArrayQueue<E> implements Queue<E> {
    private int capacity = 8;
    private E q[];
    private int size;
    protected int first;
    protected int next;
    public ArrayQueue(){
        first = -1;
        next = 0;
        q = (E[]) new Object[capacity];
    }
    public ArrayQueue(int cap){
        capacity = cap;
        q = (E[]) new Object[capacity];
    }

    public void enqueue(E e) {
           if(next == first)
            System.out.println("fila cheia!");
            else {
                if(first == -1)
                    first = next;
                q[next] = e;
                next = ++next % capacity;
            }
    }

    public E dequeue() throws EmptyQueueException{
        if(isEmpty())
            throw new EmptyQueueException("Queue is empty");
        E e = q[first];
        q[first] = null;
        first = (++first) % capacity;
        return e;

    }
    public E first() throws EmptyQueueException{
        if(isEmpty())
            throw new EmptyQueueException("Fila vazia");
        return q[first];
    }
    public int size(){
        return (capacity - first + next) % capacity;
    }
    public boolean isEmpty(){
        return first == -1;
    }
    public String toString(){
        return "";
    }
}
