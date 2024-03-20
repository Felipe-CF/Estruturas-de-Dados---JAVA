package vetor.linked_list;
import deques.NodeDeck;
import vetor.array.EmptyVectorException;
import vetor.array.Vetor;

public class Vector<E> implements Vetor<E>{
    protected NodeDeck<E>.Node<E> first;
    protected NodeDeck<E>.Node<E> last;
    protected int size;
    public Vector(){
        first = null;
        last = null;
        size=0;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    private void addFirst(E e){
        NodeDeck<E> outclass = new NodeDeck<E>();
        NodeDeck<E>.Node<E> newNode = outclass.new Node<E>(e);
        newNode.setNext(first.getNext());
        first.setNext(newNode);
    }
    // private void addLast(E e){
    //     NodeDeck<E> outclass = new NodeDeck<E>();
    //     NodeDeck<E>.Node<E> newNode = outclass.new Node<E>(e);
    //     newNode.setPrev(last.getPrev());
    //     last.setPrev(newNode);
    // }

    public boolean indexCheck(int i) throws IndexOutOfBoundsException{
        return (i > 0) || (i < size); 
    }

    private NodeDeck<E>.Node<E> returnNode(int i){
        NodeDeck<E>.Node<E> current;
        if(i <= size()/2){
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
        return current;
    }

    public E elemAtRank(int i) throws IndexOutOfBoundsException, EmptyVectorException{
        if(!indexCheck(i))
            throw new IndexOutOfBoundsException("Indice fora do vetor");
        if(isEmpty())
            throw new EmptyVectorException("Vetor vazio");
        NodeDeck<E>.Node<E> current;
        return returnNode(i).getElement();
    }   

    public E replaceAtRank(int i, E e) throws IndexOutOfBoundsException, EmptyVectorException{
        if(isEmpty())
            throw new EmptyVectorException("Vetor vazio");
        if(!indexCheck(i))
            throw new IndexOutOfBoundsException("Indice fora do vetor");
        NodeDeck<E>.Node<E> current = returnNode(i);
        E temp = current.getElement();
        current.setElement(e);
        return temp;
    }

    public void insertAtRank(int i, E e) throws IndexOutOfBoundsException, EmptyVectorException{
        if(!indexCheck(i))
            throw new IndexOutOfBoundsException("Indice fora do vetor");
        if(isEmpty() && i == 0){
            addFirst(e);
        }
        NodeDeck<E>.Node<E> current = returnNode(i);
        current.setElement(e);
        size++;
    }

    public E removeAtRank(int i) throws IndexOutOfBoundsException, EmptyVectorException{
        if(!indexCheck(i))
            throw new IndexOutOfBoundsException("Indice fora do vetor");
        if(isEmpty())
            throw new EmptyVectorException("Vetor vazio");
            NodeDeck<E>.Node<E> current = returnNode(i);
            NodeDeck<E>.Node<E> next = current.getNext();
            current.getPrev().setNext(current.getNext()); // o proximo do anterior será o next do atual que será removido
            next.setPrev(current.getPrev());
            size--;
            return current.getElement();
    }

    public String toString(){
        String s = "[";
        if(!isEmpty()){
            NodeDeck<E>.Node<E> current = first.getNext();
            while (current != last) {
                s += current.getElement();
                if(current.getNext() != last)
                    s += ", ";
            }
        }
        return s + "]";
    }
}
