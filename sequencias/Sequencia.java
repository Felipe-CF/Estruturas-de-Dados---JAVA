package sequencias;

public class Sequencia<E> implements Sequence<E>{
    protected int size;
    protected Node<E> header;
    protected Node<E> tail;

    public Sequencia(){
        header = new Node<E>();
        tail = new Node<E>();
        size = 0; 
    }
    
    public int size(){
        return size;
    }
    
    public boolean isEmpty(){
        return size == 0;
    }

    public Node<E> atRank(int rank){ // retornar o nó da posição i
        Node<E> current = new Node<E>(); // crio o nó atual
        if(rank <= size()/2){ // se o indice estiver mais a esquerda da sequencia...
            current = header.getNext();
            while(rank > 0){ // percorro a sequencia até achar ele
                current = current.getNext();
                rank--;
            }
        }
        else{ // se o indice estiver mais a direita da sequencia...
            rank = size() - rank - 1;
            current = tail.getPrev();
            while (rank > 0) { // percorro a sequencia até achar ele
                current = current.getPrev();
                rank--;
            }
        }
        return current; // retorno o nó
    }

    public int rankOf(Node<E> n){ // retorno o indice do nó n
        Node<E> current = header.getNext();
        int r = 0; 
        while(current != tail){ // percorro a lista incremente r e, quando achar o nó...
            if(current.getElement() == n.getElement())
                break; // paro o loop
            r++;
            current = current.getNext();
        }
        return r; // retorno o contador incrementado 
    }

    public void insertAtRank(int i, Node<E> n){
        if(isEmpty()) // se for vazia...
            throw new EmptySequenceException("Sequencia vazia");
        if(i < 0 || i >= size())// se for um indice invalido...
            throw new IndexOutOfBoundsException("indice inválido");

        Node<E> current = atRank(i); // pego o nó na posição i
        n.setNext(current); // o proximo de n recebe o atual
        n.setPrev(current.getPrev()); // o anterior de n recebe o anterior do atual
        current.getPrev().setNext(n); // o proximo, do anterior do atual, recebe n
        current.setPrev(n); // o anterior do atual recebe n
        size++; // aumento o tamanho
    }

    public E replaceAtRank(int i, Node<E> n) throws EmptySequenceException, IndexOutOfBoundsException{
        if(isEmpty()) // se for vazia...
            throw new EmptySequenceException("Sequencia vazia");
        if(i < 0 || i >= size())// se for um indice invalido...
            throw new IndexOutOfBoundsException("indice inválido");

        Node<E> current = atRank(i); // pego o nó na posição i
        current.getPrev().setNext(n); // o proximo, do anterior do atual, recebe n
        current.getNext().setPrev(n); // o anterior, do proximo do atual, recebe n
        n.setNext(current.getNext()); //  o proximo de n recebe o proximo do atual
        n.setPrev(current.getPrev()); // o anterior de n recebe o anterior do atual
        current.setNext(null); // tiro as referencias do atual
        current.setPrev(null);
        return current.getElement(); // retorno seu elemento
    }
    
    public E elemAtRank(int i) throws IndexOutOfBoundsException, EmptySequenceException{
        if(isEmpty()) // se for vazia...
            throw new EmptySequenceException("Sequencia vazia");
        if(i < 0 || i >= size())// se for um indice invalido...
            throw new IndexOutOfBoundsException("indice inválido");

        Node<E> r = atRank(i); // pego o nó no indice i  
        return r.getElement(); // retorno o elemento
    }

    public E removeAtRank(int i) throws IndexOutOfBoundsException, EmptySequenceException{
        if(isEmpty()) // se for vazia...
            throw new EmptySequenceException("Sequencia vazia");
        if(i < 0 || i >= size())// se for um indice invalido...
            throw new IndexOutOfBoundsException("indice inválido");

        Node<E> removed = atRank(i); // nó que será removido recebe o nó da posição i
        removed.getPrev().setNext(removed.getNext()); // o proximo, do anterior do removido, recebe o proximo do removido
        removed.getNext().setPrev(removed.getPrev()); // o anterior, do proximo do removido, recebe o anterior do removido
        removed.setPrev(null); // tiro as referencias dele
        removed.setNext(null);
        size--; // diminuo o tamanho
        return removed.getElement(); // retorno o elemento removido
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
        if(isEmpty()) // se vazia...
            throw new EmptySequenceException("Sequencia vazia");
        if(n.getElement() == header.getNext().getElement()) // se for o header.next...
            throw new IndexOutOfBoundsException("Sem elemento antes do primeiro");
        Node<E> current = header.getNext().getNext();
        while(current != tail){ // percorro a lista e...
            if(current.getElement() == n.getElement())
                return current.getPrev().getElement(); // retorno o nó anterior ao atual...
            current = current.getNext();
        }
        return null; // ou nulo
    }
    
    public E after(Node<E> n) throws EmptySequenceException{
        if(isEmpty()) // se vazia...
            throw new EmptySequenceException("Sequencia vazia");
        if(n.getElement() == header.getNext().getElement()) // se for o header.next...
            throw new IndexOutOfBoundsException("Sem elemento antes do primeiro");
        Node<E> current = tail.getPrev().getPrev();
        while(current != header){ // percorro a lista e...
            if(current.getElement() == n.getElement())
                return current.getNext().getElement(); // retorno o nó proximo ao atual...
            current = current.getPrev();
        }
        return null; // ou nulo
    }

    public void insertAfter(Node<E> n, E e) throws  EmptySequenceException{
        if(isEmpty()) // se for vazia...
            throw new EmptySequenceException("Sequencia vazia");

        Node<E> newNode = new Node<E>(e); // crio novo nó
        Node<E> current = header.getNext(); // e um atual
        while(current != tail){ // percorro a sequencia e quando achar o nó...
            if(current.getElement() == n.getElement()){
                newNode.setPrev(current); // anterior do novo recebe o atual
                newNode.setNext(current.getNext()); // o proximo do novo recebe o proximo do atual
                current.getNext().setPrev(newNode); //  o anterior, do proximo do atual, recebe o novo
                current.setNext(newNode); //  o proximo do atual recebe o novo
                size++; //aumento o tamanho
                return; // paro
            }
            current = current.getNext(); // pego o proximo...
        }
        
    }  

    public void insertBefore(Node<E> n, E e) throws EmptySequenceException{
        if(isEmpty()) // se vazia...
            throw new EmptySequenceException("Sequencia vazia");

        Node<E> newNode = new Node<E>(e); // crio novo nó
        Node<E> current = header.getNext(); // e um atual
        while(current != tail){ // percoro o nó...
            if(current.getElement() == n.getElement()){ // se achei o nó...
                newNode.setPrev(current.getPrev()); // o anterior do novo, recebe o anterior do atual
                newNode.setNext(current); //  o proximo do novo recebe o atual
                current.getPrev().setNext(newNode);  //  o proximo, do anterior do atual, recebe o novo
                current.setPrev(newNode); //  o anterior do atual recebe o novo
                size++; //aumento o tamanho
                return; // paro
            }
            current = current.getNext(); // pego o proximo
        }
        
    }

    public void insertFirst(Node<E> n) throws  EmptySequenceException{
        if(isEmpty()){ // se vazia
            header.setNext(n); // header e tail apontam para o novo nó
            tail.setPrev(n);
            n.setPrev(header); // o anterior dele é o header
            n.setNext(tail); // o proximo dele é o tail
        }
        else{
            n.setPrev(header);  // o anterior dele é o header
            n.setNext(header.getNext()); // o proximo dele é o proximo do header
            header.getNext().setPrev(n); // o anterior, do proximo do header, recebe o novo
            header.setNext(n); // o proximo do header é o novo
        }
        size++; //aumento o tamanho
    }

    public void insertLast(Node<E> n) throws  EmptySequenceException{
        if(isEmpty()){ // se vazia
            header.setNext(n); // header e tail apontam para o novo nó
            tail.setPrev(n);
            n.setPrev(header); // o anterior dele é o header
            n.setNext(tail); // o proximo dele é o tail
        }
        else{
            n.setNext(tail); // proximo do novo é o tail
            n.setPrev(tail.getPrev()); // anterior do novo é o anterior do tail
            tail.getPrev().setNext(n); // o proximo, do anterior do tail, é o novo
            tail.setPrev(n); // o anterior do tail é o novo
        }
        size++; //aumento o tamanho
    }    
    
    public E remove(Node<E> n) throws EmptySequenceException{
        if(isEmpty()) // se vazio...
            throw new EmptySequenceException("Sequencia vazia");

        Node<E> current = header.getNext();
        while(current != tail){ // percorro a sequencia...
            if(current.getElement() == n.getElement()){ // se achie o nó...
                current.getNext().setPrev(current.getPrev()); // o anterior, do proximo do atual, recebe o anterior do atual
                current.getPrev().setNext(current.getNext()); // o proximo, do anterior do atual, recebe o proximo do atual 
                current.setNext(null); // tiro a referencia do atual...
                current.setPrev(null);
                size--; // diminuo o tamanho
                return current.getElement(); // retorno seu elemento..
            }
            current = current.getNext(); // pego o proximo
        }
        return null; // ou nulo
    }

    public E replaceElement(Node<E> n, E e) throws EmptySequenceException{
        if(isEmpty()) // se vazia...
            throw new EmptySequenceException("Sequencia vazia");

        Node<E> newNode = new Node<E>(e);
        Node<E> current = header.getNext();
        while(current != tail){ // percorro a sequencia...
            if(n.getElement() == current.getElement()){ // e se achei o nó....
                newNode.setPrev(current.getPrev()); // o anterior do novo recebe o anterior do atual
                newNode.setNext(current.getNext()); // o proximo do novo recebe o proximo do atual
                current.getPrev().setNext(newNode); // o proximo, do anterior do atual, recebe o novo
                current.getNext().setPrev(newNode); // o anterior, do proximo do atual, recebe o novo
                current.setPrev(null); // retiro as referencias...
                current.setNext(null);
                return current.getElement();// retorno o elemento...
            }
            current = current.getNext(); // pego o proximo
        }
        return null; // ou nulo
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
