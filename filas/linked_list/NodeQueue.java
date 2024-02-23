package linked_list;
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

    public Node(E e, Node<E> next, Node<E> prev) {
      element = e;
      this.next = next;
      this.prev = prev;
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
    Node<E> newNode = new Node<E>();
    newNode.setElement(e);
    if (isEmpty()) {
      first = newNode;
      last = newNode;
    } else {
      newNode.setPrev(last);
      last.setNext(newNode);
      last = newNode;
    }
    size++;
  }

  public E first() throws EmptyQueueException {
    if (isEmpty())
      throw new EmptyQueueException("Queue is empty");
    return last.getElement();
  }

  public E dequeue() throws EmptyQueueException {
    if (isEmpty())
      throw new EmptyQueueException("Queue is empty");
    E e = first.getElement();
    first = first.getNext();
    first.setPrev(null);
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