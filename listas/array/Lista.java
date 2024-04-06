package listas.array;
import listas.array.Node;
import vetor.array.EmptyVectorException;
public class Lista<E> {
    protected E[] a;
    protected int size;
    protected int cap;
    protected Node<E> last;
    protected Node<E> first;
    public Lista(){
      last = null;
      first = null;
      size = 0;
      cap=1;
      a = (E[]) new Object[cap];
  }

    public int size(){
      return size;
    }
    
    public boolean isEmpty(){
      return size == 0;
    }
    
    public boolean isFirst(Node<E> n) throws EmptyListException{
      return n.getElement() == first.getNext().getElement();
    }
    
    public boolean isLast(Node<E> n) throws EmptyListException{
      return n.getElement() == last.getPrev().getElement();
    }
    
    public E first() throws EmptyVectorException{
      return first.getNext().getElement();
    }
    public E last() throws  EmptyVectorException{
      return last.getPrev().getElement();
    }
    
    public E before(Node<E> n) throws EmptyVectorException{
      if(isEmpty())
        throw new EmptyListException("lista vazia");
      for(int i = 0; i < size; i++){
        if()
      }
    }
    public E after(Node<E> n) throws EmptyVectorException;
    
    public void insertBefore(Node<E> n, E e) throws  EmptyVectorException;
    public void insertAfter(Node<E> n, E e) throws  EmptyVectorException;    
    public void insertFirst(Node<E> n) throws  EmptyVectorException{
      
      size++;
      if(size == cap)
        increaseCapacity();
      if()
      for()
    }
    public void insertLast(Node<E> n) throws  EmptyVectorException;    
    
    public E remove(Node<E> n) throws EmptyVectorException;
    public E replaceElement(Node<E> n, E e) throws EmptyVectorException;
    public E swapElements(Node<E> n, E e) throws EmptyVectorException;
    
    public void increaseCapacity();
    public void decreaseCapacity();

}
