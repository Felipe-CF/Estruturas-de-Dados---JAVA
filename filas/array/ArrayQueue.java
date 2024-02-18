package array;

public class ArrayQueue<E> implements Queue<E> {
    private int capacity = 100;
    private E Q[];
    private int size;
    public ArrayQueue(){
        Q = (E[]) new Object[capacity];
    }
    public ArrayQueue(int cap){
        capacity = cap;
        Q = (E[]) new Object[capacity];
    }

    public void enqueue(E e) {
        if(size == capacity)
            throw new FullQueueException()
        
    }

    public E dequeue();
    public E front();
    public int size();
    public boolean isEmpty();
    public String toString();
}
