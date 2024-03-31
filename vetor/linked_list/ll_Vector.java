package vetor.linked_list;
import vetor.array.EmptyVectorException;
import vetor.array.Vetor;

public class ll_Vector<E> implements Vetor<E>{
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

    public E replaceAtRank(int i, E e) throws IndexOutOfBoundsException, EmptyVectorException{
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
            i = size()-i;
            while(i > 0){
                current = current.getPrev();
                i--;
            }
        }
        E temp = current.getElement();
        current.setElement(e);
        return temp;

    }

    public void insertAtRank(int i, E e) throws IndexOutOfBoundsException, EmptyVectorException{
        if(isEmpty()){
            if(i == 0){
                Node<E> newNode = new Node<E>(e);
                newNode.setPrev(first); // novo aponta para o first
                newNode.setNext(last); // novo aponta para o last
                first.setNext(newNode); // first aponta para o novo
                last.setPrev(newNode); // last aponta para o novo
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
            Node<E> newNode = new Node<E>(e);
            Node<E> current = new Node<E>();
            if(i < size()/2){ // se o indice estiver no lado esquerdo
                current = first.getNext();
                while(i > 0){ // percorre até a posição
                    current = current.getNext();
                    i--;
                }
            }
            else { // se o indice estiver no lado direito
                current = last.getPrev(); // percorre até a posição
                i = (size()-1) - i; //  a diferença aqui me retorna a quantidade de elementos 
                // entre o ultimo e o i   
                while(i > 0){ // percorre até a posição
                    current = current.getPrev();
                    i--;
                }
            }
            newNode.setNext(current.getNext()); // o next do novo será o next do atual
            newNode.setPrev(current); // o prev do novo será o atual
            current.getNext().setPrev(newNode); // o prev do next do atual será o novo
            current.setNext(newNode); // o next do atial é o novo
            size++;
            if(size == cap)
                increaseCapacity();
        }    
        
    }

    public E removeAtRank(int i) throws IndexOutOfBoundsException, EmptyVectorException{
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
