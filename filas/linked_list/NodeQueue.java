package linked_list;
import linkedList.NodeStack;
public class NodeQueue<E> implements Queue<E> {
  public class Node<E> {
      private E element;
      private Node<E> next;
      public Node() {
        element = null;
        next = null;
      }
  
      public Node(E e, Node<E> next) {
        element = e;
        this.next = next;
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

  }
  protected Node<E> first;
  protected Node<E> last;
  protected int size;
  public NodeQueue(){size = 0;first = null;last = null;}
  public int size(){
    return size;
  }
  public boolean isEmpty(){
    return size == 0;
  }
  public void setFirst(Node<E> node){
    first = node;
  }
  public void enqueue(E e){
      Node<E> newNode = new Node<E>();
      newNode.setElement(e);
      newNode.setNext(null);
      if(isEmpty())
          setFirst(newNode);
      else
          last.setNext(newNode);
      last = newNode;
      size++;
  }
public E dequeue() throws EmptyQueueException{
      if(isEmpty())
          throw new EmptyQueueException("Fila vazia");
        E e = first.getElement();
        setFirst(first.getNext());
        size--;
      if(isEmpty())
        last = null;
        return e;
}
public E first() throws EmptyQueueException{
  if(isEmpty())
      throw new EmptyQueueException("Fila Vazia");
  else
      return first.getElement();
}

public void inverter(){
  NodeStack<E> pilha = new NodeStack<E>();
  while(first != null)
    pilha.push(dequeue());
   size=0;
   while(!pilha.isEmpty())
     enqueue(pilha.pop());

}

public String toString(){
  String s = "[";
      Node<E> current = first;
      while(current != null){
          s += current.getElement();
          if(current != last)
              s += ", ";
          current = current.getNext();
      }

  s += "]";
  return s;
}
}
