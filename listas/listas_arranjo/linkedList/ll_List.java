package listas.listas_arranjo.linkedList;

public class ll_List<E> implements ListArray<E> {
    public class Node<E> {
        private E element;
        private Node<E> next;
        private Node<E> prev;
        public Node() {element = null; next = null; prev = null;}
        public Node(E e) {element = e;}
        public E getElement() {return element;}
        public void setElement(E newElem) {element = newElem;}
        public void setNext(Node<E> newNext) {next = newNext;}
        public Node<E> getNext() {return next;}
        public void setPrev(Node<E> newPrev) {prev = newPrev;}
        public Node<E> getPrev() {return prev;}
      }
    protected Node<E> first;
    protected Node<E> last;
    protected int size;
    public ll_List(){
      first = new Node<E>();
      last = new Node<E>();
      first.setNext(last);
      last.setPrev(first);
      size=0;
    }
    public int size(){
      return size;
    }
    public boolean isEmpty(){
      return size == 0;
    } 

    public E first() throws EmptyListException{
      if(isEmpty())
        throw new EmptyListException("Lista vazia");
      return  first.getElement();
    }

    public E last() throws EmptyListException{
      if(isEmpty())
        throw new EmptyListException("Lista vazia");
      return  last.getElement();
    }

    public void insertFirst(E e) throws EmptyListException{
      Node<E> newNode = new Node<E>(e);
      if(isEmpty()){
        first.setNext(newNode);
        newNode.setPrev(first);
        newNode.setNext(last);
        last.setPrev(newNode);
      }
      else{
        newNode.setNext(first.getNext());
        newNode.setPrev(first);
        first.getNext().setPrev(newNode);
        first.setNext(newNode);
      }
      size++;
    }

    public void insertLast(E e) throws EmptyListException{
      Node<E> newNode = new Node<E>(e);
      if(isEmpty()){
        first.setNext(newNode);
        newNode.setPrev(first);
        newNode.setNext(last);
        last.setPrev(newNode);
      }
      else{
        newNode.setPrev(last.getPrev());
        newNode.setNext(last);
        last.getPrev().setNext(newNode);
        last.setPrev(newNode);
      }
      size++;
    }

    public E before(E e) throws EmptyListException{
      if(isEmpty()) // se a lista estiver  vazia...
        throw new EmptyListException("Lista vazia"); // lança erro

      Node<E> current = first.getNext(); // crio nó para percorrer os elementos da lista, até que acha o elemento
      // referencia ou, parece no last sentinela
      while(current != last){
        if(current.getElement() == e) // se ele achar o "e" referencia, para o loop
          break;
        current = current.getNext();
      }

      if(current == last) // se ele chegou no sentinela é porque o "e" não existe na lista
        return null; // retorna null para indicar o erro
      return current.getPrev().getElement(); // aqui ele achou e retorna o elemento do nó anterior

    }

    public E after(E e) throws EmptyListException{
      if(isEmpty()) // se a lista estiver  vazia...
        throw new EmptyListException("Lista vazia"); // lança erro

      Node<E> current = first.getNext(); // crio nó para percorrer os elementos da lista, até que acha o elemento
      // referencia ou, parece no last sentinela
      while(current != last){
        if(current.getElement() == e) // se ele achar o "e" referencia, para o loop
          break;
        current = current.getNext();
      }

      if(current == last) // se ele chegou no sentinela é porque o "e" não existe na lista
        return null; // retorna null para indicar o erro
      return current.getNext().getElement(); // aqui ele achou e retorna o elemento do nó anterior

    }

    public void insertBefore(E e) throws EmptyListException{
      if(isEmpty())
        throw new EmptyListException("Lista vazia");
      if(first.getNext().getElement() == e)
        insertFirst(e);
      else {
        Node<E> current = first.getNext();
        while(current != last){
          if(current.getElement() == e)
            break;
          current = current.getNext();
        }
        if(current == last)
          System.out.println("elemento não existe na lista");
        else{
          Node<E> newNode = new Node<E>(e);
          newNode.setPrev(current.getPrev());
          newNode.setNext(current);
          current.getPrev().setNext(newNode);
          current.setPrev(newNode);
          size++;
        }
      }
      
    }

    public void insertAfter(E e) throws EmptyListException{
      if(isEmpty()) // se for vazio ele imprime o erro
        throw new EmptyListException("Lista vazia");

      if(last.getPrev().getElement() == e) // se o elemento referencia for o ultimo, chamo o insertLast que tem o mesmo
        insertLast(e); // procedimento e reaproveito o codigo
      else {
        Node<E> current = first.getNext(); 
        while(current != last){ // crio um loop a partir do 1° elemento e percorro toda a lista
          if(current.getElement() == e) // caso ache o elemento referencia, paro o loop, e sigo o resto do codigo
            break;
          current = current.getNext(); // pego o proximo elemento da lista
        }
        if(current == last) // se o atual percorreu toda a lista e, chegou a se tornar igual o last
          System.out.println("elemento não existe na lista"); // significa que o elemento referencia não existe

        else{ // elemento referencia existe e faço a inserção
          Node<E> newNode = new Node<E>(e); // novo nó
          newNode.setPrev(current); // anterior do novo recebe o atual
          newNode.setNext(current.getNext()); // proximo do novo recebe o proximo do atual
          current.getNext().setPrev(newNode); // o anterior do proximo elemento recebe o novo nó
          current.setNext(newNode); // o proximo do atual recebe o novo
          size++;
        }
      }
      
    }


  }
