package deques;
public interface Deck<E>{
    public void addFirst(E e);
    public void addLast(E e);
    public int size();
    public boolean isEmpty();
    public E removeFirst() throws EmptyDeckException;
    public E removeLast() throws EmptyDeckException;
    public String toString();
  }