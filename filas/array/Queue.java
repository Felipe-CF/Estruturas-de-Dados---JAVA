package array;

public interface Queue<E> implements EmptyQueueException {
    public void enqueue(E e);
    public E dequeue();
    public E front();
    public int size();
    public boolean isEmpty();
    public String toString();
}
