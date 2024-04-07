package listas.array;
import listas.array.Node;
import vetor.array.EmptyVectorException;
public class Lista<E> {
    protected int size;
    protected Node<E> first;
    protected Node<E> last;
    public Lista(){
      size = 0;
      first = last = null;
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
    
    public E first() throws EmptyVectorException{
      if(isEmpty())
        throw new EmptyListException("Lista vazia");
      return first.getElement();
    }
    
    public E last() throws  EmptyVectorException{
      if(isEmpty())
        throw new EmptyListException("Lista vazia");
      return last.getElement();
    }
    
    public E before(Node<E> n) throws EmptyVectorException{
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
    
    public E after(Node<E> n) throws EmptyVectorException{
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
    
    public void insertBefore(Node<E> n, E e) throws  EmptyVectorException{
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

    public void insertAfter(Node<E> n, E e) throws  EmptyVectorException{
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

    public void insertFirst(Node<E> n) throws  EmptyVectorException{
      if(size() == 0){ // se a lista estiver vaziaa
        first.setNext(n); // o proximo do primeiro sentinela recebe n
        last.setPrev(n); // o anterior do ultimo sentinela recebe n
      }
      else { // se não for
        first.getNext().setPrev(n); // o anterior, do proximo do primeiro sentinela, recebe n
        first.setNext(n); // o proximo do primeiro sentinela recebe n
      } 
      size++; // aumento o tamanho
        
    }

    public void insertLast(Node<E> n) throws  EmptyVectorException{
      if(size() == 0){ // se a lista estiver vaziaa
        first.setNext(n); // o proximo do primeiro sentinela recebe n
        last.setPrev(n); // o anterior do ultimo sentinela recebe n
      }
      else { // se não for
        last.getPrev().setNext(n); // o proximo, do anterior do ultimo sentinela, recebe n
        last.setPrev(n); // o anterior do ultimo sentinela recebe n
      } 
      size++; // aumento o tamanho
    }    
    
    public E remove(Node<E> n) throws EmptyVectorException{
          if(size == 0) // se a lista for vazia
            throw new EmptyListException("Lista vazia"); // imprime o erro
          E temp = null;
          if(isFirst(n)){
            Node<E> current = first.getNext(); 
            current.getNext().setPrev(first);
            first.setNext(current.getNext());
            current.setNext(null);
            current.setPrev(null);
            temp = current.getElement();
          }
          else if(isLast(n)){
            Node<E> current = last.getPrev(); 
            current.getPrev().setNext(last);
            last.setPrev(current.getPrev());
            current.setNext(null);
            current.setPrev(null);
            temp = current.getElement();
          }
          else{
            Node<E> current = first.getNext().getNext();
            while(current.getElement() != last.getPrev()){
              if(current.getElement() == n.getElement()){
                
              }
            } 

          }
          // se não for...
          Node<E> current ; // crio um novo array com o tamanho do atual -1
          return null;

    }

    public E replaceElement(Node<E> n, E e) throws EmptyVectorException{
        if(size == 0) // se for vazia...
          throw new EmptyListException("Lista vazia"); // imprimo o erro
        E temp = null; // crio uma variavel temporaria recebe primeiro null
        Node<E> newNode = new Node<E>(e); // crio um no nó com o valor a ser colocado na lista

        for(int i = 0; i < size; i++){ // percorro a lista
          if(a[i].getElement() == n.getElement()){ // e se achar o nó n
            temp = a[i].getElement(); // armazeno o valor dele para retorno
            a[i] = newNode; // e substituo n pelo novo nó
            break; // paro o loop
          }
        }
        if(temp == null) // se o valor não for encontrado...
          System.err.println("Valor não encontrado na lista"); // imprimo o erro
        return temp; // retorno temp
    }

    public void swapElements(Node<E> n, Node<E> q) throws EmptyVectorException{
      if(isEmpty()) // se a lista for vazia...
        throw new EmptyListException("Lista vazia"); // imprime o erro
      if(size() == 1) // se a lista tiver 1 nó...
        throw new EmptyListException("Lista com apenas um elemento"); // imprime o erro

      int ind_n = -1; // crio uma variavel para armazenar a posição do nó n
      int ind_q = -1; // crio uma variavel para armazenar a posição do nó q
      // o valor -1 indica que não tem um indice do array a

      for(int i =0; i < size; i++){ // percorro o loop...
          if(a[i].getElement() == n.getElement() && ind_n == -1) // se acho o nó e o ind_n não foi preenchido
            ind_n = i; // guardo i
          else if(a[i].getElement() == q.getElement() && ind_q == -1) // se acho o nó e o ind_q não foi preenchido
            ind_q = i; // guardo i
      }

      if(ind_n == -1 && ind_q == -1) // se os dois forem vazios
        System.err.println("Nenhum elemento encontrado");
      else if(ind_n == -1 || ind_q == -1) // se um dos dois for vazio
        System.err.println("Um dos elementos não encontrado");

      else{ // os 2 foram encontrados e trocar de posição
        a[ind_n] = q;
        a[ind_q] = n;
      }

    }
    
    public String toString(){
      String s = "[";
      for(int i = 0; i < size; i++){
          s += a[i].getElement();
          if(i != size-1)
              s += ", ";
      }
      s += "]";
      return s;
  }

}
