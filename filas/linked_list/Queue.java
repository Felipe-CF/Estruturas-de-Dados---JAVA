package linked_list;
public interface Queue<E>{
  public void enqueue(E e);
  public E dequeue() throws EmptyQueueException;

  public int size();

  public boolean isEmpty();

  public E first() throws EmptyQueueException;
}
