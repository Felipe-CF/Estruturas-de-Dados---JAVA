package LInkedList;
public class NodeQueue<E> implements Queue<E> {
    public class Node<E> {
      private E element;
      private Node<E> next;
      private Node<E> prev;
      public Node() {
        element = null;
        next = null;
        prev = null;
      }
  
      // o método push() chama esse método para inserir na pilha
      public Node(E e) {
        element = e;
      }
  
      public E getElement() {
        return element;
      }
  
      public void setElement(E newElem) {
        element = newElem;
      }
  
      public void setNext(Node<E> newNext) {
        next = newNext;
      }
  
      public Node<E> getNext() {
        return next;
      }
  
      public void setPrev(Node<E> newPrev) {
        prev = newPrev;
      }
  
      public Node<E> getPrev() {
        return prev;
      }
    }
  
    private Node<E> first;
    private Node<E> last;
    private int size;
  
    public NodeQueue() {
      size = 0;
      first = null;
      last = null;
    }
  
    public int size() {
      return size;
    }
  
    public boolean isEmpty() {
      return size == 0;
    }
  
    public void enqueue(E e) {
      Node<E> newNode = new Node<E>(e);
      if (isEmpty()) {
        first = newNode;
        last = newNode;
      } else {
        newNode.setNext(first);
        first.setPrev(newNode);
        first = newNode;
      }
      size++;
    }
  
    public E last() throws EmptyQueueException {
      if (isEmpty())
        throw new EmptyQueueException("Queue is empty");
      return last.getElement();
    }
  
    public E dequeue() throws EmptyQueueException {
      if (isEmpty())
        throw new EmptyQueueException("Queue is empty");
      Node<E> temp = last;
      last = temp.getPrev();
      last.setNext(null);
      E e = temp.getElement();
      size--;
      return e;
    }
  
    public String toString() {
      String s = "[";
      if (!isEmpty()) {
        Node<E> aux = first;
        while (aux != null) {
          s += aux.getElement();
          if (aux != last)
            s += ", ";
          aux = aux.getNext();
        }
      }
      s += "]";
      return s;
    }
  
  }