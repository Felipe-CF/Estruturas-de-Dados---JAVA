package array;
public interface Queue<E>{
    public void enqueue(E e);
    public E dequeue()throws EmptyQueueException;
    public E first() throws EmptyQueueException;
    public int size();
    public boolean isEmpty();
    public String toString();
}
