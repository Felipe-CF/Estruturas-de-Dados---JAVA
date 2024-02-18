public interface stack<E> {
  public void push(E e);
  public E pop() throws EmptyStackException;
  public int size();
  public boolean isEmpty();
  public E top() throws EmptyStackException;
}
