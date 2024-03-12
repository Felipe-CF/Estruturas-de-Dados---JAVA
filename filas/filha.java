import array.Queue;
import linkedList.NodeStack;
import linked_list.EmptyQueueException;

// fila com 2 pilhas
public class filha<E> implements Queue<E> {
    // 2 pilhas
    protected NodeStack<E> p1;
    protected NodeStack<E> p2;
    protected int size;
    protected NodeStack<E>.Node<E> first;
    public filha(){
        p1 = new NodeStack<E>();    p2 = new NodeStack<E>();
        size=0;
    }   
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public E first() throws EmptyQueueException{
        if(p1.isEmpty())
            throw new EmptyQueueException("Fila vazia");
        slinkyp2();
        E temp = p2.last().getElem();
        slinkyp1(); 
        return temp;
    }
    public void enqueue(E e){
        p1.push(e);
        if(p1.size() == 1)
            first = p1.last();
        size++; 
    }
    public E dequeue(E e) throws EmptyQueueException{
        if(p1.isEmpty())
            throw new EmptyQueueException("Fila vazia");
        slinkyp2();
        E temp = p2.pop();
        first = p2.last();
        slinkyp1();
        size--;
        return temp;
    }
    private void slinkyp2(){ // trasnfere para p2
        while(!p1.isEmpty())
            p2.push(p1.pop());
    }
    private void slinkyp1(){  // trasnfere para p1
        while(!p2.isEmpty())
            p1.push(p2.pop());
    }
    public String toString(){
        String s = "[";
        if(!isEmpty()){
            slinkyp2();
            NodeStack<E>.Node<E> cursor = p2.last();
            while(cursor != null){
                s += cursor.getElem();
                if(cursor.getNext() != null){
                    s += ", ";
                }
                cursor = cursor.getNext();
            }
            slinkyp1();
        }
         return s + "]";
    }

}
