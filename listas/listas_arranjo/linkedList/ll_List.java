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
      if(isEmpty()) // se a lista for vazia lance erro
        throw new EmptyListException("Lista vazia");
      return  first.getElement(); // retorna o elemento do primeiro
    }

    public E last() throws EmptyListException{
      if(isEmpty()) // se a lista for vazia lance erro
        throw new EmptyListException("Lista vazia");
      return  last.getElement(); // retorna o elemento do ultimo
    }

    public void insertFirst(E e) throws EmptyListException{
      Node<E> newNode = new Node<E>(e);
      if(isEmpty()){
        first.setNext(newNode); // o proximo do primeiro recebe o novo nó
        newNode.setPrev(first); // o anterior do  novo nó recebe o primeiro
        newNode.setNext(last); // o proximo do  novo nó recebe o ultimo
        last.setPrev(newNode); // o anterior do ultimo recebe o novo nó 
      }
      else{
        newNode.setNext(first.getNext()); // o proximo do novo nó recebe o proximo do primeiro 
        newNode.setPrev(first); // o anterior do novo nó recebe o primeiro
        first.getNext().setPrev(newNode); // o anterior, do proximo do primeiro, recebe o novo nó
        first.setNext(newNode); // o proximo do primeiro recebe o novo nó
      }
      size++;
    }

    public void insertLast(E e) throws EmptyListException{
      Node<E> newNode = new Node<E>(e);
      if(isEmpty()){ // se a lista for vazio
        first.setNext(newNode); // o proximo do primeiro recebe o novo nó
        newNode.setPrev(first); // o anterior do  novo nó recebe o primeiro
        newNode.setNext(last); // o proximo do  novo nó recebe o ultimo
        last.setPrev(newNode); // o anterior do ultimo recebe o novo nó 
      }
      else{
        newNode.setPrev(last.getPrev()); // o anterior do novo nó recebe o anterior do ultimo
        newNode.setNext(last); // o proximo do novo nó recebe o ultimo
        last.getPrev().setNext(newNode); // o proximo, do anterior do ultimo, recebe o novo nó
        last.setPrev(newNode); // o anterior do ultimo recebe o novo nó
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
      if(isEmpty()) // se a lista for vazia imprime erro
        throw new EmptyListException("Lista vazia");
      if(first.getNext().getElement() == e) // se o elemento referencial for o primeiro
        insertFirst(e); // insere antes do primeiro
      else {
        Node<E> current = first.getNext();
        while(current != last){ // percorro a lista até o atual seja o ultimo
          if(current.getElement() == e) // se o elemento referencial for encontrado, sai do loop
            break;
          current = current.getNext(); // atual recebe o proximo
        }
        if(current == last) // se atual for ultimo, então não existe o elemento na lista
          System.out.println("elemento não existe na lista");
        else{
          Node<E> newNode = new Node<E>(e); // elemento referencial encontrado 
          newNode.setPrev(current.getPrev()); // o anterior do novo nó recebe o anterior do atual
          newNode.setNext(current); // o proximo do novo nó recebe o atual
          current.getPrev().setNext(newNode); // o proximo, do anterior do atual, recebe novo nó
          current.setPrev(newNode); // o anterior do atual recebe novo nó
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

    public E remove(E e) throws EmptyListException{
      if(isEmpty())
        throw new EmptyListException("Lista vazia");
      Node<E> current = first.getNext();
      while(current != last){
        if(current.getElement() == e)
          break;
        current = current.getNext();
      }
      if(current == last)
        return null;
      E temp = current.getElement();
      current.getPrev().setNext(current.getNext());
      current.getNext().setPrev(current.getPrev());
      return temp;

    }


  }
