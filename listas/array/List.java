package listas.array;
import vetor.array.EmptyVectorException;

public interface List<E>  {
    public int size();
    public boolean isEmpty();
    public boolean isFirst() throws EmptyVectorException;
    public boolean isLast() throws EmptyVectorException;
    public E first() throws IndexOutOfBoundsException, EmptyVectorException;
    public E last() throws IndexOutOfBoundsException, EmptyVectorException;
    public E before() throws EmptyVectorException;
    public E after() throws EmptyVectorException;
    
    public void insertBefore(E e, E o) throws  EmptyVectorException;
    public void insertAfter(E e, E o) throws  EmptyVectorException;    
    public void insertFirst(E e) throws  EmptyVectorException;
    public void insertLast(E e) throws  EmptyVectorException;    
    
    public E remove(E e) throws EmptyVectorException;
    public E replaceElement(E o, E n) throws EmptyVectorException;
    public E swapElements(E o, E n) throws EmptyVectorException; 
}
