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

    public E removeAtRank(int i) throws IndexOutOfBoundsException, EmptySequenceException{
        Node<E> removed = atRank(i);
        removed.getPrev().setNext(removed.getNext());
        removed.getNext().setPrev(removed.getPrev());
        removed.setPrev(null);
        removed.setNext(null);
        size--;
        return removed.getElement();
    }

    public boolean isFirst(Node<E> n) throws EmptySequenceException{
        if(isEmpty())
            throw new EmptySequenceException("Sequencia vazia");
        return n.getElement() == header.getNext().getElement();
      }
      
    public boolean isLast(Node<E> n) throws EmptySequenceException{
        if(isEmpty())
            throw new EmptySequenceException("Sequencia vazia");
        return n.getElement() == tail.getNext().getElement();
    }
    
    public E first() throws EmptySequenceException{
        if(isEmpty())
            throw new EmptySequenceException("Sequencia vazia");
        return header.getNext().getElement();
    }
    
    public E last() throws  EmptySequenceException{
        if(isEmpty())
            throw new EmptySequenceException("Sequencia vazia");
        return tail.getNext().getElement();
    }
    
    public E before(Node<E> n) throws EmptySequenceException{
        if(isEmpty())
            throw new EmptySequenceException("Sequencia vazia");
        if(n.getElement() == header.getNext().getElement())
            throw new IndexOutOfBoundsException("Sem elemento antes do primeiro");
        Node<E> current = header.getNext().getNext();
        while(current != tail){
            if(current.getElement() == n.getElement())
                return current.getPrev().getElement();
            current = current.getNext();
        }
        return null;
    }
    
    public E after(Node<E> n) throws EmptySequenceException{
        if(isEmpty())
            throw new EmptySequenceException("Sequencia vazia");
        if(n.getElement() == tail.getPrev().getElement())
            throw new IndexOutOfBoundsException("Sem elemento antes do primeiro");
        Node<E> current = tail.getPrev().getPrev();
        while(current != header){
            if(current.getElement() == n.getElement())
                return current.getNext().getElement();
            current = current.getPrev();
        }
        return null;
    }

    public void insertAfter(Node<E> n, E e) throws  EmptySequenceException{
        if(isEmpty())
            throw new EmptySequenceException("Sequencia vazia");

        Node<E> newNode = new Node<E>(e);
        Node<E> current = header.getNext();
        while(current != tail){
            if(current.getElement() == n.getElement()){
                newNode.setPrev(current);
                newNode.setNext(current.getNext());
                current.getNext().setPrev(newNode);
                current.setNext(newNode);
                size++;
                return;
            }
            current = current.getNext();
        }
        
    }  

    public void insertBefore(Node<E> n, E e) throws EmptySequenceException{
        if(isEmpty())
            throw new EmptySequenceException("Sequencia vazia");

        Node<E> newNode = new Node<E>(e);
        Node<E> current = header.getNext();
        while(current != tail){
            if(current.getElement() == n.getElement()){
                newNode.setPrev(current.getPrev());
                newNode.setNext(current);
                current.getPrev().setNext(newNode);
                current.setPrev(newNode);
                size++;
                return;
            }
            current = current.getNext();
        }
        
    }

    public void insertFirst(Node<E> n) throws  EmptySequenceException{
        if(isEmpty()){
            header.setNext(n);
            tail.setPrev(n);
            n.setPrev(header);
            n.setNext(tail);
        }
        else{
            n.setPrev(header);
            n.setNext(header.getNext());
            header.getNext().setPrev(n);
            header.setNext(n);
        }
        size++;
    }

    public void insertLast(Node<E> n) throws  EmptySequenceException{
        if(isEmpty()){
            header.setNext(n);
            tail.setPrev(n);
            n.setPrev(header);
            n.setNext(tail);
        }
        else{
            n.setNext(tail);
            n.setPrev(tail.getPrev());
            tail.getPrev().setNext(n);
            tail.setPrev(n);
        }
        size++;
    }    
    
    public E remove(Node<E> n) throws EmptySequenceException{
        if(isEmpty())
            throw new EmptySequenceException("Sequencia vazia");

        Node<E> current = header.getNext();
        while(current != tail){
            if(current.getElement() == n.getElement()){
                current.getNext().setPrev(current.getPrev());
                current.getPrev().setNext(current.getNext());
                current.setNext(null);
                current.setPrev(null);
                size--;
                return current.getElement();
            }
            current = current.getNext();
        }
        return null;
    }

    public E replaceElement(Node<E> n, E e) throws EmptySequenceException{
        if(isEmpty())
            throw new EmptySequenceException("Sequencia vazia");

        Node<E> newNode = new Node<E>(e);
        Node<E> current = header.getNext();
        while(current != tail){
            if(n.getElement() == current.getElement()){
                newNode.setPrev(current.getPrev());
                newNode.setNext(current.getNext());
                current.getPrev().setNext(newNode);
                current.getNext().setPrev(newNode);
                current.setPrev(null);
                current.setNext(null);
                return current.getElement();
            }
            current = current.getNext();
        }
        return null;
    }

    public void swapElements(Node<E> n, Node<E> q) throws EmptySequenceException{
        if(isEmpty()) // se a lista for vazia...
            throw new EmptySequenceException("Lista vazia"); // imprime o erro
        if(size() == 1) // se a lista tiver 1 nó...
            throw new EmptySequenceException("Lista com apenas um elemento"); // imprime o erro

      // checar se os nós passados estão presentes na lista
      boolean in_n = false; // variavel para armazenar se n está na lista
      boolean in_q = false; // variavel para armazenar se q está na lista
      Node<E> aux = new Node<E>(); // crio uma variavel para armazenar o valor que foi trocado de lugar
        // sem ela ocorria uma redundancia (um elemento mudava de posição, depois era revertido) 
        // ou apenas uma posição era trocada
      Node<E> find = header.getNext();
      while(find != tail){ // percorro a lista...
        if(find.getElement() == n.getElement() && !in_n) // e se "n" estiver...
          in_n = true; // confirmo
        else if(find.getElement() == q.getElement() && !in_q) // e se "q" estiver...
          in_q = true; // confirmo
        find = find.getNext();
      }

      if(in_n && in_q){ // se os dois nós estão na lista...
        Node<E> current = header.getNext(); // atual recebe o primeiro nó
        
        while(current != tail){ // percorro a lista...
          if(current.getElement() == n.getElement()){ // se n for achado...
            aux = n; // aux recebe o valor dele
            n = new Node<E>(); // deixo n nulo

            current.getPrev().setNext(q); // insiro o nó q na lista
            current.getNext().setPrev(q); 
            q.setNext(current.getNext()); // e removo o atual
            q.setPrev(current.getPrev());
            current = current.getNext(); // pego o proximo elemento para continuar com a troca
            break; // interrompo o loop
          }

          else if(current.getElement() == q.getElement()){ // se q for achado ...
            aux = q; // aux recebe o valor dele
            q = new Node<E>(); // deixo q nulo

            current.getPrev().setNext(n); // insiro o nó n na lista
            current.getNext().setPrev(n); 
            n.setNext(current.getNext()); // e removo o atual
            n.setPrev(current.getPrev());
            current = current.getNext();// pego o proximo elemento para continuar com a troca
            break; // interrompo o loop
          }
          current = current.getNext(); // passo para o proximo nó e continuo o loop
        }

        while(current != tail){
          if(current.getElement() == q.getElement() && n.getElement() == null){ // se q for achado e já tiver sido "setado"
            current.getPrev().setNext(aux); // insiro o nó q na lista
            current.getNext().setPrev(aux); 
            aux.setNext(current.getNext()); // e removo o atual
            aux.setPrev(current.getPrev());
            break; // interrompo o loop
          }
          if(current.getElement() == n.getElement() && q.getElement() == null){ // se n for achado e já tiver sido "setado"
            current.getPrev().setNext(aux); // insiro o nó n na lista
            current.getNext().setPrev(aux); 
            aux.setNext(current.getNext()); // e removo o atual
            aux.setPrev(current.getPrev());
            break; // interrompo o loop
          }

          current = current.getNext(); // passo para o proximo nó
        }

      }
      else  // se algum nó não estiver na lista
        System.out.println("Elemento(s) não presente(s) na lista");
    }
    
    public String toString(){
        String s = "[";
        Node<E> current = header.getNext();
        while (current != tail) {
            s += current.getElement();
            if(current.getNext() != tail)
                s += ", ";
            current = current.getNext();
        }
        return s + "]";
    }

}
