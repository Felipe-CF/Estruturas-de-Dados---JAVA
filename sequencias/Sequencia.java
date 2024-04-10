package sequencias;

public class Sequencia<E> implements Sequence<E>{
    protected int size;
    protected Node<E> header;
    protected Node<E> tail;

    public Sequencia(){
        header = tail = null;
        size = 0; 
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public Node<E> atRank(int rank){
        Node<E> current = new Node<E>();
        if(rank <= size()/2){
            current = current.getNext();
            while(rank > 0){
                current = current.getNext();
                rank--;
            }
        }
        else{
            rank = size() - rank - 1;
            while (rank > 0) {
                current = current.getNext();
                rank--;
            }
        }

        return current;
    }

    public int rankOf(Node<E> n){
        Node<E> current = header.getNext();
        int r = 0;
        while(current != tail){
            if(current.getElement() == n.getElement())
                break;
            r++;
            current = current.getNext();
        }
        return r;
    }


    public void insertAtRank(int i, Node<E> n){
        Node<E> current = atRank(i);
        n.setNext(current);
        n.setPrev(current.getPrev());
        current.getPrev().setNext(n);
        current.setPrev(n);
        size++;
    }

    public E replaceAtRank(int i, Node<E> n) throws EmptySequenceException, IndexOutOfBoundsException{
        Node<E> current = atRank(i);
        current.getPrev().setNext(n);
        current.getNext().setPrev(n);
        n.setNext(current.getNext());
        n.setPrev(current.getPrev());
        current.setNext(null);
        current.setPrev(null);
        return current.getElement();
    }
    
    public E elemAtRank(int i) throws IndexOutOfBoundsException, EmptySequenceException{
        if(isEmpty())
            throw new EmptySequenceException("Sequencia vazia");
        Node<E> r = atRank(i);
        return r.getElement();
    }

    public boolean isFirst(Node<E> n) throws EmptySequenceException{
        return n.getElement() == header.getElement();
      }
      
      public boolean isLast(Node<E> n) throws EmptySequenceException{
        return n.getElement() == tail.getElement();
      }
      
      public E first() throws EmptySequenceException{
        return null;
    }
      
      public E last() throws  EmptySequenceException{
        return null;
      }
      
      public E before(Node<E> n) throws EmptySequenceException{
        if(isEmpty())
            throw new EmptySequenceException("Sequencia vazia");
        if(n.getElement() == header.getNext().getElement())
            throw new IndexOutOfBoundsException("Sem elemento antes do primeiro");
        
        return null;
        
      }
      
      public E after(Node<E> n) throws EmptySequenceException{
        return null;
        
      }
  
      public void insertAfter(Node<E> n, E e) throws  EmptySequenceException{
        
      }  
  
      public void insertFirst(Node<E> n) throws  EmptySequenceException{
          
      }
  
      public void insertLast(Node<E> n) throws  EmptySequenceException{
        
      }    
      
      public E remove(Node<E> n) throws EmptySequenceException{
        return null;
      }
  
      public E replaceElement(Node<E> n, E e) throws EmptySequenceException{
        return null;
    }
  
      public void swapElements(Node<E> n, Node<E> q) throws EmptySequenceException{
  
      }
      

      public String toString(){
        return "s";
      }

}