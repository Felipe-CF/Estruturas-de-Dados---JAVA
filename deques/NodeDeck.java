package deques;

public class NodeDeck<E> implements Deck<E>{
    public class Node<E> {
      private E element;
      private Node<E> next;
      private Node<E> prev;
      public Node() {element = null;  next = null; prev = null;}
      public Node(E e) {element = e;}

      public E getElement() {return element;}
      public void setElement(E newElem) {element = newElem;}

      public void setNext(Node<E> newNext) {next = newNext;}
      public Node<E> getNext() {return next;}
      
      public void setPrev(Node<E> newPrev) {prev = newPrev;}
      public Node<E> getPrev() {return prev;}
    }
    private Node<E> first;
    private Node<E> last;
    private int size;
    public NodeDeck(){
      first = last = null;
      size=0;
    }
    public void addFirst(E e){
      Node<E> newNode = new Node<E>(e);
      if(first == null){
        last = newNode;
        first = newNode;
      }else{
        newNode.setNext(first);
        first.setPrev(newNode);
        first = newNode;
      }
      size++;
    }

    public void addLast(E e){
      Node<E> newNode = new Node<E>(e);
      if(first == null){
        last = newNode;
        first = newNode;
      }else{
        newNode.setPrev(last);
        last.setNext(newNode);
        last = newNode;
      }
      size++;
    }

    public E removeFirst() throws EmptyDeckException{
      if(size ==0)
        throw new EmptyDeckException("Deck is empty");
      Node<E> temp = first;
      first = first.getNext();
      E e = temp.getElement();
      size--;
      temp = null;
      return e;
    }

    public E removeLast() throws EmptyDeckException{
      if(size ==0)
        throw new EmptyDeckException("Deck is empty");
      Node<E> temp = last;
      last = last.getPrev();
      last.setNext(null);
      E e = temp.getElement();
      size--;
      temp = null;
      return e;
    }

    public int size(){
      return size;
    }

    public boolean isEmpty(){
      return size == 0;
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