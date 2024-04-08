package listas.linked_list;


public class Lista<E> {
    protected int size;
    protected Node<E> first;
    protected Node<E> last;
    public Lista(){
      size = 0;
      first = new Node<E>();
      last = new Node<E>();
      first.setNext(last);
      last.setPrev(first);
  }

    public int size(){
      return size;
    }
    
    public boolean isEmpty(){
      return size == 0;
    }
    
    public boolean isFirst(Node<E> n) throws EmptyListException{
      return n.getElement() == first.getElement();
    }
    
    public boolean isLast(Node<E> n) throws EmptyListException{
      return n.getElement() == last.getElement();
    }
    
    public E first() throws EmptyListException{
      if(isEmpty())
        throw new EmptyListException("Lista vazia");
      return first.getElement();
    }
    
    public E last() throws  EmptyListException{
      if(isEmpty())
        throw new EmptyListException("Lista vazia");
      return last.getElement();
    }
    
    public E before(Node<E> n) throws EmptyListException{
      if(isEmpty()) // se vazio...
        throw new EmptyListException("Lista vazia"); // imprime o erro
      if(n.getElement() == first.getElement() || size == 1) // se o n for o primeiro nó...
        throw new IndexOutOfBoundsException("Sem elementos antes do primeiro"); // imprime o erro

      Node<E> current = last.getPrev(); // crio um nó para percorer a lista começando do ultimo
      while(current != first.getNext()){ // até que chegue no primeiro elemento
        if(current.getElement() == n.getElement()) // se o atualelemento for igual ao elemento de n
          return current.getPrev().getElement(); // retorno o anterior do elemento atual
        current = current.getPrev(); // passo para o proximo nó
      }
      return null; // se não achei o elemento eu retorno null
      
    }
    
    public E after(Node<E> n) throws EmptyListException{
      if(isEmpty()) // se vazio...
        throw new EmptyListException("Lista vazia"); // imprime o erro
      if(n.getElement() == first.getElement() || size == 1) // se o n for o primeiro nó...
        throw new IndexOutOfBoundsException("Sem elementos antes do primeiro"); // imprime o erro

      Node<E> current = first.getNext(); // crio um nó para percorer a lista começando do primeiro
      while(current != last.getPrev()){ // até que chegue no ultimo elemento
        if(current.getElement() == n.getElement()) // se o atual elemento for igual ao elemento de n
          return current.getNext().getElement(); // retorno o proximo elemento 
        current = current.getNext(); // passo para o proximo nó
      }
      return null; // se não achei o elemento eu retorno null

  }
    
    public void insertBefore(Node<E> n, E e) throws  EmptyListException{
      if(isEmpty()) // se for vazia...
        throw new EmptyListException("Lista vazia"); // imprime o erro

      Node<E> newNode = new Node<E>(e); // crio o novo nó
      Node<E> current = last.getPrev();
      while(current != first){ // até que chegue no primeiro elemento sentinela
        if(current.getElement() == n.getElement()){ // se o atual elemento for igual ao elemento de n
          newNode.setNext(current); // o proximo do novo nó recebe o atual 
          newNode.setPrev(current.getPrev()); // o anterior  do novo nó recebe o anterior do atual 
          current.getPrev().setNext(newNode); // o proximo, do anterior do atual, recebe o novo nó 
          current.setPrev(newNode); // o  anterior do atual, recebe o novo nó 
          size++;
          return;
        }
        current = current.getPrev(); // passo para o nó anterior
      }
      
    }

    public void insertAfter(Node<E> n, E e) throws  EmptyListException{
      if(isEmpty()) // se for vazia...
        throw new EmptyListException("Lista vazia"); // imprime o erro

      Node<E> newNode = new Node<E>(e); // crio o novo nó
      Node<E> current = first.getNext();
      while(current != last){ // até que chegue no ultimo elemento sentinela
        if(current.getElement() == n.getElement()){ // se o atual elemento for igual ao elemento de n
          newNode.setNext(current.getNext()); // o proximo do novo nó recebe o proximo do atual 
          newNode.setPrev(current); // o anterior do novo nó recebe o atual 
          current.getNext().setPrev(newNode); // o anterior, do proximo do atual, recebe o novo nó 
          current.setNext(newNode); // o  proximo do atual, recebe o novo nó 
          size++;
          return;
        }
        current = current.getPrev(); // passo para o nó seguinte
      }
    }  

    public void insertFirst(Node<E> n) throws  EmptyListException{
      if(size() == 0){ // se a lista estiver vaziaa
        first.setNext(n); // o proximo do primeiro sentinela recebe n
        last.setPrev(n); // o anterior do ultimo sentinela recebe n
        n.setPrev(first); // o anterior de n recebe o primeiro sentinela
        n.setNext(last);  // o proximo de n recebe o ultimo sentinela
      }
      else { // se não for
        n.setPrev(first); // o anterior de n recebe o anterior do ultimo sentinela
        n.setNext(first.getNext()); // o proximo de n recebe o ultimo sentinela
        first.getNext().setPrev(n); // o anterior, do proximo do primeiro sentinela, recebe n
        first.setNext(n); // o proximo do primeiro sentinela recebe n
      } 
      size++; // aumento o tamanho
        
    }

    public void insertLast(Node<E> n) throws  EmptyListException{
      if(size() == 0){ // se a lista estiver vaziaa
        first.setNext(n); // o proximo do primeiro sentinela recebe n
        last.setPrev(n); // o anterior do ultimo sentinela recebe n
        n.setPrev(first); // o anterior do nó recebe o primeiro sentinela
        n.setNext(last); // o proximo do nó recebe o ultimo sentinela
      }
      else { // se não for
        n.setPrev(last.getPrev()); // o anterior de n recebe o anterior do ultimo sentinela
        n.setNext(last); // o proximo de n recebe o ultimo sentinela
        last.getPrev().setNext(n); // o proximo, do anterior do ultimo sentinela, recebe n
        last.setPrev(n); // o anterior do ultimo sentinela recebe n
      } 
      size++; // aumento o tamanho
    }    
    
    public E remove(Node<E> n) throws EmptyListException{
          if(size == 0) // se a lista for vazia
            throw new EmptyListException("Lista vazia"); // imprime o erro
          E temp = null; // cria a variavel de retorno
            Node<E> current = first.getNext();  // atual recebe o 1° nó da lista 

            while(current != last){ // percorre a lista até o ultimo nó
              if(current.getElement() == n.getElement()){  // se achei o nó referencia
                temp = current.getElement(); // pego seu elemento
                current.getPrev().setNext(current.getNext()); // o proximo, do anterior do atual, recebe o proximo do atual
                current.getNext().setPrev(current.getPrev()); // o anterior, do proximo do atual, recebe o anterior do atual
                current.setNext(null);// retiro as referencias do atual
                current.setPrev(null);
                size--; // reduzo o tamanho
                break; // paro o loop
              }
              current = current.getNext();
            } 
          return temp; // retorno o elemento removido ou null

    }

    public E replaceElement(Node<E> n, E e) throws EmptyListException{
        if(size == 0) // se for vazia...
          throw new EmptyListException("Lista vazia"); // imprimo o erro

        E temp = null; // crio uma variavel temporaria nula
        Node<E> current = first.getNext(); // crio um no nó com o valor a ser colocado na lista
        while(current != last){ // percorro a lista até o ultimo nó sentinela
          if(n.getElement() == current.getElement()){ // se achei o nó referencia
            temp = current.getElement(); // pego o seu elemnto
            current.setElement(e); // "seto" um novo elemento
            break; // paro o laço
          }
          current = current.getNext(); // passo para o proximo do atual
        }
        return temp; // retorno elemento removido ou null
    }

    public void swapElements(Node<E> n, Node<E> q) throws EmptyListException{
      if(isEmpty()) // se a lista for vazia...
        throw new EmptyListException("Lista vazia"); // imprime o erro
      if(size() == 1) // se a lista tiver 1 nó...
        throw new EmptyListException("Lista com apenas um elemento"); // imprime o erro

      Node<E> current = first.getNext(); // atual recebe o primeiro nó
      while(current != last){
        if(current.getElement() == n.getElement()){ // se n for achado e não tiver sido "setado"
          current.getPrev().setNext(q);
          current.getNext().setPrev(q); // insiro o nó q na lista
          q.setNext(current.getNext()); // e removo o atual
          q.setPrev(current.getPrev());
          current.setNext(null);
          current.setPrev(null);
          break;
        }
        current = current.getNext(); // passo para o proximo nó
      }

      // Node<E> current2 = first.getNext(); // atual recebe o primeiro nó
      while(current != last){ // percorre a lista até o ultimo sentinela
        if(current.getElement() == q.getElement()){ // se q for achado e não tiver sido "setado"
        current.getPrev().setNext(n);
        current.getNext().setPrev(n); // insiro o nó n na lista
        n.setNext(current.getNext()); // e removo o atual
        n.setPrev(current.getPrev());
        current.setNext(null);
        current.setPrev(null);
        break;
        }
        current = current.getNext(); // passo para o proximo nó
      }
    }
    
    public String toString(){
      String s = "[";
      if(size > 0){
        Node<E> current = first.getNext();
        while(current != last){
          s += current.getElement();
          if(current.getNext() != last)
            s += ", ";
          current = current.getNext();
        }
      }
      s += "]";
      return s;
  }

}
