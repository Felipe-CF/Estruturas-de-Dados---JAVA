package listas.linked_list;

import listas.array.Node;

public interface List<E>  {
    public int size();
    public boolean isEmpty();
    public boolean isFirst(Node<E> n) throws EmptyListException;
    public boolean isLast(Node<E> n) throws EmptyListException;
    public E first() throws EmptyListException;
    public E last() throws  EmptyListException;
    public E before(Node<E> n) throws EmptyListException, IndexOutOfBoundsException;
    public E after(Node<E> n) throws EmptyListException, IndexOutOfBoundsException;
    
    public void insertBefore(Node<E> n, E e) throws  EmptyListException, IndexOutOfBoundsException;
    public void insertAfter(Node<E> n, E e) throws  EmptyListException, IndexOutOfBoundsException;    
    public void insertFirst(Node<E> n) throws  EmptyListException;
    public void insertLast(Node<E> n) throws  EmptyListException;    
    
    public E remove(Node<E> n) throws EmptyListException;
    public E replaceElement(Node<E> n, E e) throws EmptyListException;
    public E swapElements(Node<E> n, Node<E> q) throws EmptyListException;
    
    public void increaseCapacity();
    public void decreaseCapacity();
}
