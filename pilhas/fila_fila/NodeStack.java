package fila_fila;
import array.EmptyStackException;
import linked_list.NodeQueue;
public class NodeStack<E> implements Stack<E> {
    protected NodeQueue<E> fila;
    protected NodeQueue<E> filha;
//    protected int size;
    public NodeStack(){
        fila = new NodeQueue<E>();
        filha = new NodeQueue<E>();
    }
    public boolean isEmpty(){
        return fila.isEmpty();
    }
    public E top() throws EmptyStackException{
        if(isEmpty())
        throw new EmptyStackException("Pilha vazia");
        return fila.first();
    }
    public void push(E e){
        // instaciar a classe externa
        NodeQueue<E> f = new NodeQueue<E>();
        NodeQueue<E>.Node<E> node = f.new Node<E>();
        // novo nodo criado
        node.setElement(e);
        fila.enqueue(e);
        filha.setFirst(node);
    }
    public E pop(){
        if(isEmpty())
            throw new EmptyStackException("Pilha vazia");
        E e = filha.dequeue();
        
        
    }
    
    
        

}
