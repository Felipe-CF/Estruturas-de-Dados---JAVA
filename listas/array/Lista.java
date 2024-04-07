package listas.array;
import listas.array.Node;
import vetor.array.EmptyVectorException;
public class Lista<E> {
    protected Node<E>[] a;
    protected int size;
    protected int cap;
    public Lista(){
      size = 0;
      cap = 1;
      a =  new Node[cap];
  }

    public int size(){
      return size;
    }
    
    public boolean isEmpty(){
      return size == 0;
    }
    
    public void increaseCapacity(){
      cap*=2;
        Node<E>[] newArray =  new Node[cap];
        for(int i = 0; i < size; i++)
            newArray[i] = a[i];
        a = newArray;
    }
    
    public void decreaseCapacity(){
      cap/=2;
        Node<E>[] newArray =  new Node[cap];
        for(int i = 0; i < size; i++)
            newArray[i] = a[i];
        a = newArray;
    }

    public boolean isFirst(Node<E> n) throws EmptyListException{
      return n.getElement() == a[0].getElement();
    }
    
    public boolean isLast(Node<E> n) throws EmptyListException{
      return n.getElement() == a[size-1].getElement();
    }
    
    public E first() throws EmptyVectorException{
      if(isEmpty())
        throw new EmptyListException("Lista vazia");
      return a[0].getElement();
    }
    
    public E last() throws  EmptyVectorException{
      if(isEmpty())
        throw new EmptyListException("Lista vazia");
      return a[size-1].getElement();
    }
    
    public E before(Node<E> n) throws EmptyVectorException{
      if(isEmpty()) // se vazio...
        throw new EmptyListException("Lista vazia"); // imprime o erro
      if(a[size-1].getElement() == n.getElement()) // se o n for o ultimo nó...
        throw new IndexOutOfBoundsException("Sem elementos além do ultimo"); // imprime o erro

      int ind_n = -1; // crio uma var vazia para o indice referencia da lista
      for(int i = 0; i < size; i++){ // percorro a lista
        if(a[i].getElement() == n.getElement()){ // se achei o nó referencia
          ind_n = i-1; // pego a posição subsequente a ele 
          break; // paro o loop
        }
      }
      if(ind_n == -1){  // se não achou o nó...{}
        System.err.println("Nó não encontrado"); // imprime o erro
        return null; // e retorna null
      } 
        return a[ind_n].getElement(); // retorno o proximo de n
    }
    
    public E after(Node<E> n) throws EmptyVectorException{
      if(isEmpty()) // se vazio...
        throw new EmptyListException("Lista vazia"); // imprime o erro
      if(a[size-1].getElement() == n.getElement()) // se o n for o ultimo nó...
        throw new IndexOutOfBoundsException("Sem elementos além do ultimo"); // imprime o erro

      int ind_n = -1; // crio uma var vazia para o indice referencia da lista
      for(int i = 0; i < size; i++){ // percorro a lista
        if(a[i].getElement() == n.getElement()){ // se achei o nó referencia
          ind_n = i+1; // pego a posição subsequente a ele 
          break; // paro o loop
        }
      }
      if(ind_n == -1){  // se não achou o nó...{}
        System.err.println("Nó não encontrado"); // imprime o erro
        return null; // e retorna null
      } 
        return a[ind_n].getElement(); // retorno o proximo de n

  }
    
    public void insertBefore(Node<E> n, E e) throws  EmptyVectorException{
      if(isEmpty()) // se for vazia...
        throw new EmptyListException("Lista vazia"); // imprime o erro

      Node<E> newNode = new Node<E>(e); // crio o novo nó

      if(n.getElement() == a[0].getElement()){ // se n for o first
        size++; // aumento o tamanho do array
        if(size() == cap)  // se estiver cheio
          increaseCapacity(); // aumento a capacidade

        for(int i = size-1; i >= 0; i--) // percorro o array... 
          a[i+1] = a[i]; // copiando o nó i para a posição i+1
        a[0] = newNode; // adiciono ele antes do first
      }

      else{

        int ind_n = -1; // crio uma var vazia para o indice referencia da lista
        for(int i = 0; i < size; i++){ // percorro a lista
          if(a[i].getElement() == n.getElement()){ // se achei o nó referencia
            ind_n = i; // pego a posição dele 
            break; // paro o loop
          }
        }

        if(ind_n == -1) // se não achou o nó...
          System.err.println("Nó não encontrado"); // imprime o erro

        else{ // se achou...
          for(int i = size-1; i > ind_n-1; i--) // percorro o array... 
              a[i+1] = a[i]; // copiando o nó i para a posição i+1
          a[ind_n] = newNode; // insiro na posição certa o novo nó
          size++; // aumento o tamanho
          if(size() == cap) // se estiver cheio...
            increaseCapacity(); // amplio
        }
        
      }
    }

    public void insertAfter(Node<E> n, E e) throws  EmptyVectorException{
      if(isEmpty()) // se for vazia...
        throw new EmptyListException("Lista vazia"); // imprime o erro

      Node<E> newNode = new Node<E>(e); // crio o novo nó
      if(n.getElement() == a[size-1].getElement()){ // se n for o last
        a[size++] = newNode; // adiciono ele a frente do last
        if(size() == cap)  // se estiver cheio
          increaseCapacity(); // aumento a capacidade
      }
      else{

        int ind_n = -1; // crio uma var vazia para o indice referencia da lista
        for(int i = 0; i < size; i++){ // percorro a lista
          if(a[i].getElement() == n.getElement()){ // se achei o nó referencia
            ind_n = i; // pego a posição  dele 
            break; // paro o loop
          }

        }

        if(ind_n == -1) // se não achou o nó...
          System.err.println("Nó não encontrado"); // imprime o erro

        else{ // se achou...
          for(int i = size-1; i > ind_n; i--) // percorro o array... 
              a[i+1] = a[i]; // copiando o nó i para a posição i+1
          a[ind_n+1] = newNode; // insiro na posição certa o novo nó
          size++; // aumento o tamanho
          if(size() == cap) // se estiver cheio...
            increaseCapacity(); // amplio
        }
        
      }
    }  

    public void insertFirst(Node<E> n) throws  EmptyVectorException{
      if(size() == 0){ // se a lista estiver vaziaa
        a[0] = n; //  insiro o 1° nó
        size++; //amplio o tamanho da lista
        increaseCapacity(); // amplio a capacidade da lista
      }
      else{ // se não for
        if(size == cap-1) // checo se a inserção vai encher a lista
          increaseCapacity(); // se sim, amplio a capacidade da lista

        for(int i = size; i > 0; i--) // percorro a lista 
          a[i] = a[i-1]; // copiando o nó para a posição seguinte
        a[0] = n; // adiciono o nó na primeira posição
        size++;  //  amplio a capacidade da lista
      }
    }

    public void insertLast(Node<E> n) throws  EmptyVectorException{
      if(size() == 0){ // se a lista estiver vaziaa
        a[0] = n; //  insiro o 1° nó
        size++; //amplio o tamanho da lista
        increaseCapacity(); // amplio a capacidade da lista
      }
      else{ // se não for
        if(size == cap) // checo se a lista está cheia
          increaseCapacity(); // se sim, amplio a capacidade da lista
        a[size] = n; // o elemento no indice size recebe o nó
        size++;  //  amplio a capacidade da lista
      }
    }    
    
    public E remove(Node<E> n) throws EmptyVectorException{
          if(size == 0) // se a lista for vazia
            throw new EmptyListException("Lista vazia"); // imprime o erro
      
          // se não for...
          Node<E>[] new_a = new Node[--size]; // crio um novo array com o tamanho do atual -1
          Node<E> r = null; // crio um nó que irá retornar o elemento removido
          int j = -1; // crio um contador para preencher o new_a

          for(int i = 0; i < size; i++){ // percorro o array a em busca do elemento do nó passado
              // se ele for o elemento que estou buscando, pego o indice dele e seu conteudo 
              System.out.println(a[i].getElement());
              if(n.getElement() == a[i].getElement()){
                  r.setElement(a[i].getElement()); 
                  j = i;
                  break;
              } 
                
          }
          System.out.println(r.getElement());
          if(j == -1) // se não achou o elemento...
            return null;

          else{
            for(int i = j; i < size; i--) // percorro o array deslocando os elementos para esquerda
              a[i] = a[i+1];
            size--; // diminuo o tamanho
            return r.getElement(); // retorno o elemento removido
          }

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
