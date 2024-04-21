package teste;


public class ll_Vector<E> {
    protected Node<E> first;
    protected Node<E> last;
    protected int size;
    public ll_Vector(){
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

    public E elemAtRank(int i) throws IndexOutOfBoundsException, EmptyVectorException{
        if(isEmpty())
            throw new EmptyVectorException("Vetor vazio");
        if((i < 0) || (i >= size))
            throw new IndexOutOfBoundsException("Indice fora do vetor");

        Node<E> current;
        if(i <= size()/2){
            current = first.getNext();
            while(i > 0){
                current = current.getNext();
                i--;
            }
        }
        else {
            current = last;
            i = (size()-i);
            while(i > 0){
                current = current.getPrev();
                i--;
            }
        }
        return current.getElement();

    }   

    public E replaceAtRank(int i, E o) throws IndexOutOfBoundsException, EmptyVectorException{ // alterar para NODE
        if(isEmpty()) // se o vetor for vazio, lança o erro
            throw new EmptyVectorException("Vetor vazio");
        if((i < 0) || (i >= size)) // se o indice passado não for válido, lança o erro
            throw new IndexOutOfBoundsException("Indice fora do vetor");
        
        Node<E> current; // crio o nó 'atual' para percorrer o vetor
        if(i < size()/2){ // se o indice que queremos estar mais a esquerda do vetor, 
            current = first.getNext();// percorra ele apartir do proximo do first até o indice passado
            while(i > 0){ 
                current = current.getNext();
                i--;
            }
        }
        else {
            // se o indice que queremos estar mais a direta do vetor, percorra ele apartir do anterior
            // do last até o indice passado -1
            current = last;
            i = size()-i;
            while(i > 0){
                current = current.getPrev(); 
                i--;
            }
        } 
        E temp = current.getElement();
        Node<E> n = new Node<E>(o); // crio novo nó
        current.setElement(o);
        return temp; // retorno seu elemento e garbageColector da fim a ele

    }

    public void insertAtRank(int i, E o) throws IndexOutOfBoundsException, EmptyVectorException{ // alterar para NODE
        if(isEmpty()){ // vector vazio precisa do indiice 0 para iniciar
            if(i == 0){
                Node<E> n = new Node<E>(o);
                n.setPrev(first); // novo aponta para o first
                n.setNext(last); // novo aponta para o last
                first.setNext(n); // first aponta para o novo
                last.setPrev(n); // last aponta para o novo
            }
            else
                throw new EmptyVectorException("Vetor vazio");    
        } 
        
        else if(i < 0 || i > size){ // se o indice passado estiver fora do alcance do vetor
            throw new IndexOutOfBoundsException("Indice fora do vetor");
        }

        else{
            Node<E> current; // crio nó para percorrer o vetor
            if(i <= size()/2){ // se o indice estiver no lado esquerdo
                System.out.println(" < size/2");
                current = first.getNext();
                while(i > 0){ // percorre até a posição
                    current = current.getNext();
                    i--;
                }
            }
            else{
                i = (size()-i);
                current = last;
                while( i > 0){
                    current = current.getPrev();
                    i--;
                }
            }
            Node<E> n = new Node<E>(o);
            n.setNext(current); // o next do novo será o next do atual
            n.setPrev(current.getPrev()); // o prev do novo será o atual
            current.getPrev().setNext(n); // o prev do next do atual será o novo
            current.setPrev(n); // o next do atual é o novo
        }    
        size++;
    }

    public E removeAtRank(int i) throws IndexOutOfBoundsException, EmptyVectorException{
        if(isEmpty())
            throw new EmptyVectorException("Vetor vazio");
        if((i < 0) || i >= size)
            throw new IndexOutOfBoundsException("Indice fora do vetor");
        
        Node<E> current;
        if(i < size()/2){
            current = first.getNext();
            while(i > 0){
                current = current.getNext();
                i--;
            }
        }
        else {
            current = last;
            i = (size()-i);
            while(i > 0){
                current = current.getPrev();
                i--;
            }
        }
        E temp = current.getElement();
        current.getPrev().setNext(current.getNext());
        current.getNext().setPrev(current.getPrev());
        current.setNext(null);
        current.setPrev(null);
        size--;
        return current.getElement();
    }

    public String toString(){
        String s = "[";
        if(!isEmpty()){
             Node<E> current = first.getNext();
            // System.out.println(current.getElement());
            // current = current.getNext();
            // System.out.println(current.getElement());
            while (current != last) {
                s += current.getElement();
                if(current.getNext() != last)
                    s += ", ";
                current = current.getNext();
            }
        }
        return s + "]";
    }
    
}
