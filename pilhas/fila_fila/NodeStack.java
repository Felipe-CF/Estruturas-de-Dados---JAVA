package fila_fila;
import array.EmptyStackException;
import linked_list.NodeQueue;
import linked_list.NodeQueue.Node;
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
        Node<E> n = new Node<E>(e);

    }
}
