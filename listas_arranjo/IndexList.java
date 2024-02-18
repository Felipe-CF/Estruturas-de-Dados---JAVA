package listas_arranjo;

public interface IndexList<E>{
    public int size();
    public boolean isEmpty();
    public void Add(int i, E e) throws IndexOutOfBoundsException;
    public E set(int p, E e) throws IndexOutOfBoundsException;
    public E get(int i) throws IndexOutOfBoundsException;
    public void remove(int i) throws IndexOutOfBoundsException;
}
