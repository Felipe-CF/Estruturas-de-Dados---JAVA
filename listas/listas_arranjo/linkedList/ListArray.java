package listas.listas_arranjo.linkedList;

public interface ListArray<E> {
    public int size();
    public boolean isEmpty();
    public E First() throws EmptyListException;
    public E Last() throws EmptyListException;
    public void insertFirst(E e);
    public void insertLast(E e);
    public void insertBefore(E e, int ind) throws EmptyListException;
    public void insertAfter(E e, int ind) throws EmptyListException;
    public E before() throws EmptyListException;
    public E after() throws EmptyListException;
    public void replaceElement(E e, E o) throws EmptyListException;
    public void swapElement(E e, E o) throws EmptyListException;
    public E remove(int ind) throws EmptyListException;
} 
