package fila_fila;
import array.EmptyStackException;
import linked_list.NodeQueue;
public class NodeStack<E> implements Stack<E> {
    protected NodeQueue<E> fila;
    protected NodeQueue<E> filha;
    protected int size;
    public NodeStack(){
        fila = new NodeQueue<E>();
        filha = new NodeQueue<E>();
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public E top() throws EmptyStackException{
        if(isEmpty())
        throw new EmptyStackException("Pilha vazia");
        return fila.first();
    }
    public void push(E e){
        NodeQueue<E> f = new NodeQueue<E>();
        NodeQueue<E>.Node<E> node = f.new Node<E>();
        // novo nodo criado
        node.setElement(e);
        if(isEmpty()){
            fila.enqueue(e);
            
        }


    }
    public E pop(){
        
        
        
    }
    
    
        

}
