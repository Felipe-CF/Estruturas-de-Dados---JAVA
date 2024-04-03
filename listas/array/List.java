package listas.array;
import vetor.array.EmptyVectorException;
import listas.array.Node;

public interface List<E>  {
    public int size();
    public boolean isEmpty();
    public boolean isFirst(Node<E> n) throws EmptyVectorException;
    public boolean isLast(Node<E> n) throws EmptyVectorException;
    public E first() throws EmptyVectorException;
    public E last() throws  EmptyVectorException;
    public E before(Node<E> n) throws EmptyVectorException;
    public E after(Node<E> n) throws EmptyVectorException;
    
    public void insertBefore(Node<E> n, E e) throws  EmptyVectorException;
    public void insertAfter(Node<E> n, E e) throws  EmptyVectorException;    
    public void insertFirst(Node<E> n) throws  EmptyVectorException;
    public void insertLast(Node<E> n) throws  EmptyVectorException;    
    
    public E remove(Node<E> n) throws EmptyVectorException;
    public E replaceElement(Node<E> n, E e) throws EmptyVectorException;
    public E swapElements(Node<E> n, E e) throws EmptyVectorException;
    
    public void increaseCapacity();
    public void decreaseCapacity();
}
