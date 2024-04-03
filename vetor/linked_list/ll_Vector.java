package vetor.linked_list;
import vetor.array.EmptyVectorException;
import vetor.linked_list.Vetor;

public class ll_Vector<E> implements Vetor<E>{
    protected Node<E> first;
    protected Node<E> last;
    protected int size;
    protected int cap;
    public ll_Vector(){
        first = new Node<E>();
        last = new Node<E>();
        first.setNext(last);
        last.setPrev(first);
        size=0;
        cap=1;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public void increaseCapacity(){
        cap *= 2;
    }
    public void decreaseCapacity(){
        cap /= 2;
    }

    public E elemAtRank(int i) throws IndexOutOfBoundsException, EmptyVectorException{
        if(isEmpty())
            throw new EmptyVectorException("Vetor vazio");
        if((i < 0) || (i > size))
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
            current = last.getPrev();
            i = (size()-i)-1;
            while(i > 0){
                current = current.getPrev();
                i--;
            }
        }
        return current.getElement();

    }   

    public E replaceAtRank(int i, Node<E> n) throws IndexOutOfBoundsException, EmptyVectorException{ // alterar para NODE
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
            current = last.getPrev();
            i = size()-i;
            while(i > 0){
                current = current.getPrev(); 
                i--;
            }
        } 
   // crio novo nó
        current.getPrev().setNext(n); // o proximo, do anterior do atual, recebe o novo nó
        current.getNext().setPrev(n); // o anterior, do proximo do atual, recebe o novo nó
        current.setNext(null); // tiro as referências à outros nós do atual
        current.setPrev(null);
        return current.getElement(); // retorno seu elemento e garbageColector da fim a ele

    }

    public void insertAtRank(int i, Node<E> n) throws IndexOutOfBoundsException, EmptyVectorException{ // alterar para NODE
        if(isEmpty()){
            if(i == 0){
                n.setPrev(first); // novo aponta para o first
                n.setNext(last); // novo aponta para o last
                first.setNext(n); // first aponta para o novo
                last.setPrev(n); // last aponta para o novo
                size++;
                if(size == cap)
                    increaseCapacity();
            }
            else
                throw new EmptyVectorException("Vetor vazio");    
        } 
        // vector vazio precisa do indiice 0 para iniciar
        
        else if(i < 0 || i > size){
            throw new IndexOutOfBoundsException("Indice fora do vetor");
        }
        
        else{
            System.out.println(size);
            Node<E> current = new Node<E>();

            if(i <= size()/2){ // se o indice estiver no lado esquerdo
                System.out.println(" < size/2");
                current = first.getNext();
                while(i > 0){ // percorre até a posição
                    current = current.getNext();
                    i--;
                }
            }
            else { // se o indice estiver no lado direito
                System.out.println(" >= size/2");
                current = last.getPrev(); // percorre até a posição
                i = (size()- i) -1 ; //  a diferença aqui me retorna a quantidade de elementos 
                // entre o ultimo e o i   
                while(i > 0){ // percorre até a posição
                    current = current.getPrev();
                    i--;
                }
            }
            n.setNext(current.getNext()); // o next do novo será o next do atual
            n.setPrev(current); // o prev do novo será o atual
            current.getNext().setPrev(n); // o prev do next do atual será o novo
            current.setNext(n); // o next do atual é o novo
            size++;
            if(size == cap)
                increaseCapacity();
        }    
        
    }

    public E removeAtRank(int i) throws IndexOutOfBoundsException, EmptyVectorException{
        if(isEmpty())
            throw new EmptyVectorException("Vetor vazio");
        if((i < 0) || (i >= size))
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
            current = last.getPrev();
            i = (size()-i)-1;
            while(i > 0){
                current = current.getPrev();
                i--;
            }
        }
        current.getPrev().setNext(current.getNext());
        current.getNext().setPrev(current.getPrev());
        current.setNext(null);
        current.setPrev(null);
        size--;
        if(size== (cap*0.25))
            decreaseCapacity();
        return current.getElement();
    }

    public String toString(){
        String s = "[";
        if(!isEmpty()){
            Node<E> current = first.getNext();
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
