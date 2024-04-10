package sequencias;


public interface Sequence<E>{
    // metodos de transição
    public Node<E> atRank(int i);
    public int rankOf(Node<E> n);

    // metodos de vetor
    public E elemAtRank(int i) throws IndexOutOfBoundsException, EmptySequenceException;
    public E replaceAtRank(int i, Node<E> n) throws EmptySequenceException, IndexOutOfBoundsException;
    public void insertAtRank(int i, Node<E> n)throws IndexOutOfBoundsException;
    public E removeAtRank(int i) throws EmptySequenceException, IndexOutOfBoundsException; 
    // metodos de lista
    public boolean isFirst(Node<E> n) throws EmptySequenceException;
    public boolean isLast(Node<E> n) throws EmptySequenceException;
    public E first() throws EmptySequenceException;
    public E last() throws  EmptySequenceException;
    public E before(Node<E> n) throws EmptySequenceException;
    public E after(Node<E> n) throws EmptySequenceException;
    public void insertBefore(Node<E> n, E e) throws  EmptySequenceException;
    public void insertAfter(Node<E> n, E e) throws  EmptySequenceException;
    public void insertFirst(Node<E> n) throws  EmptySequenceException;
    public void insertLast(Node<E> n) throws  EmptySequenceException;  
    public E remove(Node<E> n) throws EmptySequenceException;
    public E replaceElement(Node<E> n, E e) throws EmptySequenceException;
    public void swapElements(Node<E> n, Node<E> q) throws EmptySequenceException;

  
}
