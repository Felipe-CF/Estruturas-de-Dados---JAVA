package linkedList;
import linked_list.NodeQueue;

public class pila<E> implements stack<E>{
    protected NodeQueue<E> f1;
    protected NodeQueue<E> f2;
    protected int size;
    public pila(){
        f1 = new NodeQueue<E>();
        f2 = new NodeQueue<E>();
        size=0; 
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size ==0;
    }
    public E top() throws EmptyStackException{
        if(f1.isEmpty())
            throw new EmptyStackException("Pilha Vazia");
        E temp = null;
        while(!f1.isEmpty()){
            if(f1.size() == 1)
                temp = f1.first();
            f2.enqueue(f1.dequeue());
        }
        jumpQueuef2(); // traz os elementos de f2 para f1
        return temp;
    }
    public E pop() throws EmptyStackException{
        if(f1.isEmpty())
            throw new EmptyStackException("Pilha vazia");
        while(f1.size() > 1)
            f2.enqueue(f1.dequeue());
        E temp = f1.dequeue();
        jumpQueuef2();
        size--;
        return temp;    
    }
    public void push(E e){
        f1.enqueue(e);
        size++;
    }
    private void jumpQueuef2(){
        while(!f2.isEmpty())
            f1.enqueue(f2.dequeue());
    }
    private void jumpQueuef1(){
        while(!f1.isEmpty())
            f2.enqueue(f1.dequeue());
    }
    public String toString(){
        String s = "[";
        if(!f1.isEmpty()){
            while(!f1.isEmpty()){
                E temp = f1.dequeue();
                s += temp;
                f2.enqueue(temp);
                if(f1.size() > 0)
                    s += ", ";
            }
            jumpQueuef2();
        }
        return s+ "]";
    }
}
